package net.phutee.data.api;

import java.util.*;

import net.phutee.data.domain.Division;

public class PopulatorAPIImpl implements PopulatorAPI {
    
    Map<Division,String> urlsByDivision;
    Map<Map<String,String>, JsoupRecipe> recipesByUrlAndData;
    
    JsoupParser parser;
    
    public PopulatorAPIImpl() {
	// TODO - initialize urlsByDivision through config
	urlsByDivision = new HashMap<Division,String>();
	urlsByDivision.put(Division.ENGLISH_PREMIERSHIP,"http://www.statto.com/football/stats/england/premier-league");
	urlsByDivision.put(Division.SCOTTISH_PREMIERSHIP, "http://www.statto.com/football/stats/scotland/premiership");
	urlsByDivision.put(Division.SCOTTISH_CHAMPIONSHIP, "http://www.statto.com/football/stats/scotland/championship");

	// TODO - initialize recipesByUrlAndData through config
	
	Map<String,String> englishPremTeams = new HashMap<String,String>();
	englishPremTeams.put(urlsByDivision.get(Division.ENGLISH_PREMIERSHIP), TEAM_KEY);
	
	Map<String,String> scottishPremTeams = new HashMap<String,String>();
	englishPremTeams.put(urlsByDivision.get(Division.SCOTTISH_PREMIERSHIP), TEAM_KEY);
	
	Map<String,String> scottishChampTeams = new HashMap<String,String>();
	englishPremTeams.put(urlsByDivision.get(Division.SCOTTISH_CHAMPIONSHIP), TEAM_KEY);
	
	recipesByUrlAndData = new HashMap<Map<String,String>,JsoupRecipe>();
	recipesByUrlAndData.put(englishPremTeams, new StattoRecipes.TeamRecipe());
	recipesByUrlAndData.put(scottishPremTeams, new StattoRecipes.TeamRecipe());
	recipesByUrlAndData.put(scottishChampTeams, new StattoRecipes.TeamRecipe());
	
	parser = new JsoupParser();
    }

    @Override
    public Map<String, List<Object>> getAllTeamsByDivision() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Object> getTeamsForDivision(Division division) {

	List<Object> teams = null;
	
	String url = urlsByDivision.get(division);
	if (url != null) {
	    Map<String,String> urlByDataKey = new HashMap<String,String>();
	    urlByDataKey.put(url, TEAM_KEY);
	    JsoupRecipe recipe = recipesByUrlAndData.get(urlByDataKey);
	    
	    try {
		// cook it
		Map<String, List<Object>> results = 
			parser
			  .cook(url, recipe)
			  .getResults();
		
		teams = results.get(TEAM_KEY);

	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
	return teams;
    }

    public Map<Division, String> getUrlsByDivision() {
        return urlsByDivision;
    }

    public void setUrlsByDivision(Map<Division, String> urlsByDivision) {
        this.urlsByDivision = urlsByDivision;
    }
    
    

}
