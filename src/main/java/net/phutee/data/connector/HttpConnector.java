package net.phutee.data.connector;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpConnector implements StreamConnector {

	@Override
	public InputStream connect(String location) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(location);
		
		CloseableHttpResponse response = null;
		InputStream inputStream = null;
		
		response = httpclient.execute(httpGet);
		inputStream = response.getEntity().getContent();	
		
		return inputStream; 
	}

}