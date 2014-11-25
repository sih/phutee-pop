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
	expected.append(TEAM_NAME);
	expected.append(",");
	expected.append(PLAYED);
	expected.append(",");
	expected.append(GD);
	expected.append(",");
	expected.append(POINTS);
	expected.append(",");
	expected.append(FORM);
	
	assertEquals(expected.toString(),csv);
    
    }
}
