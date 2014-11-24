package net.phutee.data.api;

import java.util.*;

import net.phutee.data.domain.Team;

import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class StattoRecipes {

    static final String TEAMS = "teams";
    static final String TABLE_CSS_SELECTOR = "div.tableMini";
    static final String TEAM_CSS_SELECTOR = "tr[class~=c[0|1]] > td.steam";
    static final String TEAM_DETAILS_CSS_SELECTOR = "tr[class~=c[0|1]] > td:gt(1)";

    static class TeamRecipe implements JsoupRecipe {

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
			if (counter == 0)
			    team.setPlayed(detail.text());
			else if (counter == 1)
			    team.setGoalDiff(detail.text());
			else if (counter == 2)
			    team.setPoints(detail.text());
			else if (counter == 3)
			    team.setForm(detail.text());
			else
			    break;
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
