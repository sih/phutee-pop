package net.phutee.data.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import java.util.*;

import net.phutee.data.connector.HttpConnector;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class XHtmlPopulatorAPIImplTest {

    private static final String DUMMY_SOURCE = "dummySource";
    private static final String BAD_SOURCE = "badSource";

    @Mock
    private HttpConnector connector;

    @Mock
    private InputStream mockStream;

    @InjectMocks
    private XHtmlPopulatorAPIImpl populator;
    private String source;
    private Map<String, String> menu;

    
    
    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
	try {
	    when(connector.connect(DUMMY_SOURCE)).thenReturn(mockStream);
	    when(connector.connect(BAD_SOURCE)).thenThrow(new IOException());
	}
	catch (IOException e) {
	}    
    }

    @Test
    public void testNoSource() {
	source = null;
	menu = new HashMap<String, String>();
	menu.put("name", "dummy");

	List<String> results = populator.getTeams(source, menu);
	assertTrue(results.isEmpty());

    }

    @Test
    public void testNoMenu() {
	source = DUMMY_SOURCE;
	menu = null;
	List<String> results = populator.getTeams(source, menu);
	assertTrue(results.isEmpty());
    }

    @Test
    public void testEmptyMenu() {
	source = DUMMY_SOURCE;
	menu = new HashMap<String, String>();
	List<String> results = populator.getTeams(source, menu);
	assertTrue(results.isEmpty());
    }

    
    @Test
    public void testConnectionError() {
	source = BAD_SOURCE;
	menu = new HashMap<String, String>();
	menu.put("name", "dummy");
	
	try {
	    List<String> results = populator.getTeams(source, menu);
	    assertTrue(results.isEmpty());
	}
	catch(Exception e) {
	    fail("Shouldn't have thrown a "+e.getClass());
	}
	
    }
    
}
