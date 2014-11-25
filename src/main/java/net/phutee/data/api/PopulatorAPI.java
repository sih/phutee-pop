package net.phutee.data.api;

import java.util.*;

import net.phutee.data.domain.Division;

public interface PopulatorAPI {
    
    public Map<String,List<Object>> getAllTeamsByDivision();
    
    public List<Object> getTeamsForDivision(Division division);
    
}
