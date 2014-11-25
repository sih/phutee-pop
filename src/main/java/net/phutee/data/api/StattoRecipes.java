package net.phutee.data.api;

import java.util.*;

import net.phutee.data.domain.Team;

import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class StattoRecipes {

    static final String TEAMS = "teams";
    static final String TABLE_CSS_SELECTOR = "div.tableMini";
    static final String TEAM_ROW_SELECTOR = "tr[class~=c[0|1]]";
    static final String TEAM_NAME_SELECTOR = "td.steam";
    static final String TEAM_PLAYED_SELECTOR = "td:eq(2)";
    static final String TEAM_GD_SELECTOR = "td:eq(3)";
    static final String TEAM_POINTS_SELECTOR = "td:eq(4)";
    static final String TEAM_FORM_SELECTOR = "td:eq(5)";
    // static final String TEAM_DETAILS_CSS_SELECTOR = "tr[class~=c[0|1]] > td:gt(1)";

    static class TeamRecipe implements JsoupRecipe {

	@Override
	public List<Object> cook(Document data) {
	    List<Object> results = null;
	    if (data != null) {
		results = new ArrayList<Object>();

		// HIGHLANDER
		Element tab = data.select(TABLE_CSS_SELECTOR).first();

		Elements elements = tab.select(TEAM_ROW_SELECTOR);
		
		for (Element tRow : elements) {
		    
		    String name = tRow.select(TEAM_NAME_SELECTOR).first().text();
		    Team team = new Team(name);
		    
		    String played = tRow.select(TEAM_PLAYED_SELECTOR).first().text();
		    String gd = tRow.select(TEAM_GD_SELECTOR).first().text();
		    String points = tRow.select(TEAM_POINTS_SELECTOR).first().text();
		    String form = tRow.select(TEAM_FORM_SELECTOR).first().text();
		    
		    team.setPlayed(played);
		    team.setGoalDiff(gd);
		    team.setPoints(points);
		    team.setForm(form);
		    
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
