package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_sameObj() {
        assertEquals(team.equals(team), true);
    }

    @Test
    public void equals_returns_correct_differentClass() {
        String notTeam = "Not a Team object.";
        assertFalse(team.equals(notTeam));
    }

    @Test
    public void equals_returns_correct_equalNames_equalMembers() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        team1.addMember("1");
        team2.addMember("1");
        assertEquals(team1.equals(team2), true);
    }

    @Test
    public void equals_returns_correct_equalNames_differentMembers() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        team1.addMember("1");
        team2.addMember("2");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void equals_returns_correct_differentNames() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("team-test");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void hashCode_returns_correct() {
        Team t = new Team("test-team");
        t.addMember("1");
        int tHashNumber = t.hashCode();
        assertFalse(tHashNumber == team.hashCode());

        Team t1 = new Team("test-team");
        t1.addMember("1");
        int t1HashNumber = t1.hashCode();
        assertEquals(tHashNumber, t1HashNumber);

        Team t3 = new Team("t3");
        int result = t3.hashCode();
        int expectedResult = 3647;
        assertEquals(expectedResult, result);
    }
}
