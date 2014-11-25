package net.phutee.data.api;

import static org.junit.Assert.*;

import java.util.*;

import net.phutee.data.domain.*;

import org.junit.*;

public class PopulatorAPIImplIntegrationTest {

    private PopulatorAPIImpl api;
    private Map<Division,String> urlsByDivision;
    
    
    @Before
    public void setUp() {

	api = new PopulatorAPIImpl();
	urlsByDivision = new HashMap<Division,String>();
	urlsByDivision.put(Division.ENGLISH_PREMIERSHIP,"http://www.statto.com/football/stats/england/premier-league");
	// only set up the one division for testing
	api.setUrlsByDivision(urlsByDivision);
	
    }
    
    @Test
    public void testGetTeamByDivisionNoDataThatDivision() {
	List<Object> results = api.getTeamsForDivision(Division.DUTCH_EREDIVISE);
	assertNull(results);
    }
    
    @Test
    public void testGetTeamByDivisionDataExistsThatDivision() {
	List<Object> results = api.getTeamsForDivision(Division.ENGLISH_PREMIERSHIP);
	assertNotNull(results);	
	assertEquals(20,results.size());
	
	for (Object o : results) {
	    Team t = (Team)o;
	    System.out.println(t.toJson());
	}
    }

}
