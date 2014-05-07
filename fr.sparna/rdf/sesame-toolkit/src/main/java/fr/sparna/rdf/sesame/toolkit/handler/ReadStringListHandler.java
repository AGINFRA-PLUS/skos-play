package fr.sparna.rdf.sesame.toolkit.handler;

import java.util.ArrayList;
import java.util.List;

import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.TupleQueryResultHandler;
import org.openrdf.query.TupleQueryResultHandlerBase;
import org.openrdf.query.TupleQueryResultHandlerException;

/**
 * Reads a query result consisting of a single value (Resource or Literal) possibly with multiple lines in the result set,
 * and keep the result in a List<String>, calling the stringValue() method on each Value.
 * 
 * @author Thomas Francart
 */
public class ReadStringListHandler extends TupleQueryResultHandlerBase implements TupleQueryResultHandler {

	protected List<String> result = null;
	protected String bindingName = null;

	@Override
	public void startQueryResult(List<String> bindingNames)
	throws TupleQueryResultHandlerException {	
		// if more than 1 binding name, we have a problem
		if(bindingNames.size() > 1) {
			throw new TupleQueryResultHandlerException(this.getClass().getSimpleName()+" can only read query results with a single binding.");
		}
		
		// keep track of binding name
		this.bindingName = bindingNames.get(0);
		
		// re-init result
		this.result = new ArrayList<String>();
	}
	
	@Override
	public void handleSolution(BindingSet bs)
	throws TupleQueryResultHandlerException {
		Value v = bs.getValue(this.bindingName);
		this.result.add(v.stringValue());
	}

	/**
	 * Returns the result list from this query
	 * 
	 * @return
	 */
	public List<String> getResult() {
		return result;
	}

}
