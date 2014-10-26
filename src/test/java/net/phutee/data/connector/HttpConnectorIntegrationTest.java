package net.phutee.data.connector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.phutee.data.connector.*;

import org.junit.Test;

public class HttpConnectorIntegrationTest {

	private StreamConnector connector = new HttpConnector();
	
	@Test
	public void testConnect() {
		try {
			InputStream is = connector.connect("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
			assertNotNull(is);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);
			}
			    
			in.close();
			
			
		} catch (IOException ioe) {
			fail("Shoudln't have thrown an IOE "+ioe.getMessage());
		}
		
		
	}

}
