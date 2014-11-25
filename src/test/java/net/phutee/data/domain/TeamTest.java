package net.phutee.data.domain;

import static org.junit.Assert.*;

import org.junit.*;

public class TeamTest {
    
    private Team minimalTeam;
    private Team fullTeam;
    static final String TEAM_NAME = "West Ham";
    static final String PLAYED = "12";
    static final String POINTS = "18";
    static final String GD = "+4";
    static final String FORM = "2-2-1";
    
    @Before
    public void setUp() {
	minimalTeam = new Team(TEAM_NAME);
	
	fullTeam = new Team(TEAM_NAME);
	fullTeam.setPlayed(PLAYED);
	fullTeam.setPoints(POINTS);
	fullTeam.setGoalDiff(GD);
	fullTeam.setForm(FORM);
    }

    @Test
    public void testToCsvNameOnly() {
	String csv = minimalTeam.toCsv();
	
	assertEquals(TEAM_NAME+",,,,",csv);
    }

    
    @Test
    public void testToCsvFullObject() {

	String csv = fullTeam.toCsv();
	StringBuilder expected = new StringBuilder();
	expected.append(TEAM_NAME)
	.append(",")
	.append(PLAYED)
	.append(",")
	.append(GD)
	.append(",")
	.append(POINTS)
	.append(",")
	.append(FORM);
	
	assertEquals(expected.toString(),csv);
    
    }
    
    @Test
    public void testToJsonFullObject() {
	StringBuilder expected = new StringBuilder();
	expected.append("{")
	.append("\"name\":")
	.append("\"")
	.append(TEAM_NAME)
	.append("\"")	
	.append(",")
	.append("\"played\":")
	.append("\"")
	.append(PLAYED)
	.append("\"")	
	.append(",")	
	.append("\"goalDiff\":")
	.append("\"")
	.append(GD)
	.append("\"")	
	.append(",")
	.append("\"points\":")
	.append("\"")
	.append(POINTS)
	.append("\"")	
	.append(",")	
	.append("\"form\":")
	.append("\"")
	.append(FORM)
	.append("\"")
	.append("}");	
	
	
	assertEquals(expected.toString(),fullTeam.toJson());
    }
    
    
    @Test
    public void testToJsonNameOnly() {
	StringBuilder expected = new StringBuilder();
	expected.append("{")
	.append("\"name\":")
	.append("\"")
	.append(TEAM_NAME)
	.append("\"")	

	.append("}");	
	
	
	assertEquals(expected.toString(),minimalTeam.toJson());
    }
    
}
