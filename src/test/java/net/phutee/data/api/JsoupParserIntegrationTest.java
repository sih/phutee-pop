package net.phutee.data.api;

import static org.junit.Assert.*;

import java.util.*;

import net.phutee.data.domain.Team;

import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.junit.*;

public class JsoupParserIntegrationTest {
    
    JsoupParser parser;
    
    static final String TEAMS = "teams";
    static final int DIVISION_SIZE = 20;
    
    String url;
    Set<String> menu;
    
    static final String TABLE_CSS_SELECTOR = "div.tableMini";
    static final String TEAM_CSS_SELECTOR = "tr[class~=c[0|1]] > td.steam";
    static final String TEAM_DETAILS_CSS_SELECTOR = "tr[class~=c[0|1]] > td:gt(1)";
    
    @Before
    public void setUp() {
	parser = new JsoupParser();
	url = new String("http://www.statto.com/football/stats/england/premier-league");
    }

    
    @Test
    public void test() {
	try {
	    JsoupParser p = parser.cook(url, new TeamRecipe());
	    assertNotNull(p);
	    Map<String,List<Object>> results = p.getResults();
	    assertNotNull(results);
	    assertTrue(results.containsKey(TEAMS));
	    List<Object> teams = results.get(TEAMS);
	    assertEquals(DIVISION_SIZE,teams.size());
	    
	    Team sample = (Team)teams.get(0);
	    assertNotNull(sample.getName());
	    assertNotNull(sample.getPlayed());
	    assertNotNull(sample.getGoalDiff());
	    assertNotNull(sample.getPoints());
	    assertNotNull(sample.getForm());
	    
	}
	catch (Exception e) {
	    fail("Shouldn't have throw exception "+e.getMessage());
	}
    }

    
    class TeamRecipe implements JsoupRecipe {

	@Override
	public List<Object> cook(Document data) {
	    List<Object> results = null;
	    if (data != null) {
		results = new ArrayList<Object>();
		
		// HIGHLANDER
		Element tab = data.select(TABLE_CSS_SELECTOR).first();
		
		Elements elements = tab.select(TEAM_CSS_SELECTOR);
		
		for (Element t : elements) {
		    Team team = new Team(t.text());
		    // pull the details
		    Elements details = tab.select(TEAM_DETAILS_CSS_SELECTOR);
		    int counter = 0;
		    for (Element detail : details) {
			if (counter == 0) team.setPlayed(detail.text());
			else if (counter == 1) team.setGoalDiff(detail.text());
			else if (counter == 2) team.setPoints(detail.text());
			else if (counter == 3) team.setForm(detail.text());
			else break;
			counter++;
		    }
		    
		    results.add(team);
		}
	    }
	
	    return results;
	}

	@Override
	public String getName() {
	    return TEAMS;
	}
	
    }
    
    
}
