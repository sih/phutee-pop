package net.phutee.data.api;

import java.util.*;

import net.phutee.data.domain.Division;

public class PopulatorAPIImpl implements PopulatorAPI {
    
    Map<Division,String> urlsByDivision;
    Map<String, JsoupRecipe> recipesByUrlAndData;
 
    
    JsoupParser parser;
    
    public PopulatorAPIImpl() {
	// TODO - initialize urlsByDivision through config
	urlsByDivision = new HashMap<Division,String>();
	urlsByDivision.put(Division.ENGLISH_PREMIERSHIP,"http://www.statto.com/football/stats/england/premier-league");
	urlsByDivision.put(Division.SCOTTISH_PREMIERSHIP, "http://www.statto.com/football/stats/scotland/premiership");
	urlsByDivision.put(Division.SCOTTISH_CHAMPIONSHIP, "http://www.statto.com/football/stats/scotland/championship");

	// TODO - initialize recipesByUrlAndData through config
	
	String englishPremTeams = new String(urlsByDivision.get(Division.ENGLISH_PREMIERSHIP)+"-"+StattoRecipes.TEAMS);
	String scottishPremTeams = new String(urlsByDivision.get(Division.SCOTTISH_PREMIERSHIP)+"-"+StattoRecipes.TEAMS);
	String scottishChampTeams = new String(urlsByDivision.get(Division.SCOTTISH_PREMIERSHIP)+"-"+StattoRecipes.TEAMS);
	
	recipesByUrlAndData = new HashMap<String,JsoupRecipe>();
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
	    String urlByDataKey = new String(url+"-"+StattoRecipes.TEAMS);
	    JsoupRecipe recipe = recipesByUrlAndData.get(urlByDataKey);
	    System.out.println(url);
	    System.out.println(recipe);
	    try {
		// cook it
		Map<String, List<Object>> results = 
			parser
			  .cook(url, recipe)
			  .getResults();
		
		teams = results.get(StattoRecipes.TEAMS);

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
