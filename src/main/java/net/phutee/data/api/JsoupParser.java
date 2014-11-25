package net.phutee.data.api;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.Connection;

public class JsoupParser {

    private Map<String, List<Object>> results;

    // keep hold of the document state to avoid
    private Document data;

    /**
     * @param url The resource to parse
     * @param recipe How to parse this resource
     * @return The extracted items
     * @throws Exception When the resource can't be found or parsed
     */
    public JsoupParser cook(final String url, JsoupRecipe recipe)
	    throws Exception {
	// check no GIGO	
	if (url != null && recipe != null) {
	    // either first time round or dodgy URL
	    if (null == data) {
		results = new HashMap<String, List<Object>>();
		// get the data from the url - TODO support other HTTP methods
		setData(Jsoup.connect(url).get());
	    }
	    results.put(recipe.getName(), recipe.cook(data));
	}
	 

	return this;
    }

    public Map<String, List<Object>> getResults() {
	return this.results;
    }

    void setData(Document data) {
	this.data = data;
    }
    
}
