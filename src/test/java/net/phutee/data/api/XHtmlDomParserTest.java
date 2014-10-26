package net.phutee.data.api;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class XHtmlDomParserTest {

    @Mock
    InputStream mockStream;

    @InjectMocks
    private XHtmlDomParser parser;

    @Before
    public void setUp() {
    }

    @Test
    public void testNullInputStream() {
	InputStream is = null;
	String xml;
	try {
	    xml = parser.parse(is);
	    assertNull(xml);
	}
	catch (IOException e) {
	    fail("shouldn't have thrown an exception");
	}

    }

}
