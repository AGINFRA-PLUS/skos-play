package fr.sparna.rdf.skos.xls2skos;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.RDFParserRegistry;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;

public final class ValueGeneratorFactory {

	public static ValueGeneratorIfc resources(IRI property, char separator, PrefixManager prefixManager) {
		return (model, subject, value, language, datatype) -> {
			if (StringUtils.isBlank(value)) {
				return null;
			}

			Arrays.stream(
					StringUtils.split(value, separator)
					).forEach(
							uri -> model.add(subject, property, SimpleValueFactory.getInstance().createIRI(prefixManager.uri(uri.trim(), true)))
			);
			return null;
		};
	}
	
	public static ValueGeneratorIfc resourcesOrLiteral(ColumnHeader header, char separator, PrefixManager prefixManager) {	
		return (model, subject, value, language, datatype) -> {
			if (StringUtils.isBlank(value)) {
				return null;
			}

			// if the value starts with http://, or uses a known namespace, then try to parse it as a resource
			// only if no datatype or language have been explicitely specified, in which case this will default to a literal
			if(
					datatype == null
					&&
					!header.getLanguage().isPresent()
					&&
					(value.startsWith("http://") || prefixManager.usesKnownPrefix(value.trim()))
			) {
				if(!header.isInverse()) {
					Arrays.stream(
							StringUtils.split(value, separator)
							).forEach(
									uri -> model.add(subject, header.getProperty(), SimpleValueFactory.getInstance().createIRI(prefixManager.uri(uri.trim(), false)))
					);
				} else {
					Arrays.stream(
							StringUtils.split(value, separator)
							).forEach(
									uri -> model.add(SimpleValueFactory.getInstance().createIRI(prefixManager.uri(uri.trim(), false)), header.getProperty(),subject)
					);
				}				
			// handling of rdf:list
			} else if(value.startsWith("(") && value.endsWith(")")) {
				turtleParsing(header.getProperty(), separator, prefixManager).addValue(model, subject, value, language, datatype);		
			} else if(datatype == null && value.startsWith("[") && value.endsWith("]")) {
				turtleParsing(header.getProperty(), separator, prefixManager).addValue(model, subject, value, language, datatype);
			} else {
				// if the value is surrounded with quotes, remove them, they were here to escape a URI to be considered as a literal
				String unescapedValue = (value.startsWith("\"") && value.endsWith("\""))?value.substring(1, value.length()-1):value;
				
				// consider it like a literal
				if(datatype != null) {
					Literal l = null;
					if(datatype.stringValue().equals("http://www.w3.org/2001/XMLSchema#date")) {
						Date d = ExcelHelper.asCalendar(unescapedValue.trim()).getTime();
						l = SimpleValueFactory.getInstance().createLiteral(
								new SimpleDateFormat("yyyy-MM-dd").format(d),
								SimpleValueFactory.getInstance().createIRI("http://www.w3.org/2001/XMLSchema#date")
						);
					} else if(datatype.stringValue().equals("http://www.w3.org/2001/XMLSchema#dateTime")) {
						try {
							l = SimpleValueFactory.getInstance().createLiteral(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)ExcelHelper.asCalendar(unescapedValue.trim())));
						} catch (DatatypeConfigurationException e) {
							e.printStackTrace();
						}
						
					} else {
						l = SimpleValueFactory.getInstance().createLiteral(unescapedValue.trim(), datatype);
					}
					
					model.add(subject, header.getProperty(), l);
				} else {
					langOrPlainLiteral(header.getProperty()).addValue(model, subject, value, language, datatype);
				}
			}
			
			return null;
		};
	}

	public static ValueGeneratorIfc turtleParsing(IRI property, char separator, PrefixManager prefixManager) {
		return (model, subject, value, language, datatype) -> {
			// create a small piece of Tutle by concatenating...
			StringBuffer turtle = new StringBuffer();
			// ... the prefixes				
			turtle.append(prefixManager.getPrefixesTurtleHeader());
			// ... the subject and the predicate
			turtle.append("<"+subject.stringValue()+">"+" "+"<"+property.stringValue()+"> ");
			// ... the blank node value
			turtle.append(value);
			// ... and a final dot if there is not one alreay at the end
			if(!value.trim().endsWith(".")) {
				turtle.append(".");
			}
			// now parse the Turtle String and collect the statements in a StatementCollector
			StatementCollector collector = new StatementCollector();
			RDFParser parser = RDFParserRegistry.getInstance().get(RDFFormat.TURTLE).get().getParser();
			parser.setRDFHandler(collector);
			try {
				parser.parse(new StringReader(turtle.toString()), RDF.NS.toString());
				// then add all the resulting statements to the final Model
				model.addAll(collector.getStatements());
			} catch (Exception e) {
				// if anything goes wrong, default to creating a literal
				e.printStackTrace();
				langOrPlainLiteral(property).addValue(model, subject, value, language, datatype);
			}
			
			return null;
		};
	}
	
	public static ValueGeneratorIfc dateLiteral(IRI property) {
		return (model, subject, value, language, datatype) -> {

			if (StringUtils.isBlank(value)) return null;

			try {
				model.add(
						subject,
						property,
						SimpleValueFactory.getInstance().createLiteral(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)ExcelHelper.asCalendar(value))));
			}
			catch (NumberFormatException ignore) {
			}
			catch (DatatypeConfigurationException ignore) {
				ignore.printStackTrace();
			}
			return null;
		};
	}

	public static ValueGeneratorIfc langLiteral(IRI property) {
		return (model, subject, value, language, datatype) -> {
			model.add(subject, property, SimpleValueFactory.getInstance().createLiteral(value.trim(), language));
			return null;
		};
	}

	public static ValueGeneratorIfc plainLiteral(IRI property) {
		return (model, subject, value, language, datatype) -> {
			model.add(subject, property, SimpleValueFactory.getInstance().createLiteral(value.trim()));
			return null;
		};
	}
	
	public static ValueGeneratorIfc langOrPlainLiteral(IRI property) {
		return (model, subject, value, language, datatype) -> {
			if(language != null) {
				model.add(subject, property, SimpleValueFactory.getInstance().createLiteral(value.trim(), language));
			} else {
				model.add(subject, property, SimpleValueFactory.getInstance().createLiteral(value.trim()));
			}
			return null;
		};
	}

	public static ValueGeneratorIfc skosXlLabel(IRI xlLabelProperty, PrefixManager prefixManager) {
		return (model, subject, value, language, datatype) -> {
			// String labelUri = ConceptSchemeFromExcel.fixUri(value);
			String labelUri = prefixManager.uri(value, true);
			IRI labelResource = SimpleValueFactory.getInstance().createIRI(labelUri);
			model.add(labelResource, RDF.TYPE, SKOSXL.LABEL);
			model.add(subject, xlLabelProperty, labelResource);
			return labelResource;
		};
	}

	public ValueGeneratorIfc failIfFilledIn(String property) {
		return (model, subject, value, language, datatype) -> {
			if (StringUtils.isBlank(value)) return null;
			throw new Xls2SkosException("Property not supported {} if filled in- {} - {}", property, subject, value);
		};
	}

	
}
