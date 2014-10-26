package net.phutee.data.api;

import java.io.*;
import java.util.*;

import net.phutee.data.connector.HttpConnector;

/**
 * Connects via HTTP to a source providing XHTML. It will parse this using
 * XPaths to the data elements requested.
 * 
 * @author sid
 */
public class XHtmlPopulatorAPIImpl implements PopulatorAPI {

    private HttpConnector connector;
    
    @Override
    public List<String> getTeams(String source, Map<String, String> menu) {
	List<String> data = new ArrayList<String>();	// avoid returning null

	if (source != null) {
	    // some work to do ...
	    if (menu != null && !menu.isEmpty()) {
		
		InputStream is = null;

		try {
		    is = connector.connect(source);
		}
		catch (IOException e) {
		    // do nothing
		}
		finally {
		    if (is != null) {
			try {
			    is.close();
			}
			catch (IOException e) {
			    e.printStackTrace();
			}
		    }
		}
	    }
	}

	return data;
    }

    public void setConnector(HttpConnector connector) {
        this.connector = connector;
    }

    
    
}
