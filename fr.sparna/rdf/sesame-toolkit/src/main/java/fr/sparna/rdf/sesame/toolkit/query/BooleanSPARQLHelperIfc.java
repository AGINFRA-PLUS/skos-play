package fr.sparna.rdf.sesame.toolkit.query;

import org.openrdf.query.resultio.BooleanQueryResultWriter;

/**
 * An object that associates a SPARQL query (an instance of a {@link SPARQLQueryIfc}) and a
 * <code>BooleanQueryResultWriter</code> capable of writing the boolean result of the query. The {@link fr.sparna.rdf.sesame.toolkit.query.SesameSPARQLExecuter}
 * takes this interface as a parameter of its <code>executeAsk</code> method.
 * 
 * @author Thomas Francart
 * 
 */
public interface BooleanSPARQLHelperIfc {

	/**
	 * Returns a SPARQL query along with all its execution parameters
	 * 
	 * @return a {@link fr.sparna.rdf.sesame.toolkit.query.SPARQLQueryIfc SPARQLQueryIfc} containing the SPARQL String
	 * with all its parameters.
	 */
	public abstract SPARQLQueryIfc getQuery();

	/**
	 * Returns a writer capable of processing the results of the query returned by
	 * <code>getQuery()</code>.
	 * 
	 * @return a <code>BooleanQueryResultWriter</code> that knows how to write the results of the query
	 */
	public abstract BooleanQueryResultWriter getWriter();

}