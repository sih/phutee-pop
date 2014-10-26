package net.phutee.data.connector;

import java.io.*;


/**
 * @author sid
 *
 */
public interface StreamConnector {

	InputStream connect(String location) throws IOException;
}