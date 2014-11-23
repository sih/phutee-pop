package net.phutee.data.api;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.jsoup.nodes.Document;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

public class JsoupParserTest {

    JsoupParser parser;
    
    String url;
    JsoupRecipe recipe;
    static final String MOCK_NAME = "mock";
    static final String MOCK_VALUE = "mockVal";
    
    
    @Before
    public void setUp() {
	url = "http://waldonia.eu";
	recipe = new MockRecipe();
	parser = new JsoupParser();
    }
    
    @Test
    public void testNullUrl() {
	url = null;
	JsoupParser p;
	try {
	    p = parser.cook(url, recipe);
	    assertNotNull(p);
	    Map<String,List<Object>> results = p.getResults();
	    assertNull(results);
	}
	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    

    @Test
    public void testNullRecipe() {
	recipe = null;
	JsoupParser p;
	try {
	    p = parser.cook(url, recipe);
	    assertNotNull(p);
	    Map<String,List<Object>> results = p.getResults();
	    assertNull(results);
	}
	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    
    class MockRecipe implements JsoupRecipe {

	@Override
	public List<Object> cook(Document d) {
	    List<Object> results = new ArrayList<Object>();
	    results.add(MOCK_VALUE);
	    return results;
	}

	@Override
	public String getName() {
	    return MOCK_NAME;
	}
	
    }
    

}
