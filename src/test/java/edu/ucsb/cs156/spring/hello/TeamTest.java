package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
    public void equals_returns_correct_bool() {
        // team objects are equal returns true
        assertEquals(team.equals(this.team), true);

        // different classes returns false
        assertEquals(team.equals(1), false);

        // check all other parameters
        Team team1 = new Team("first");
        Team team2 = new Team("first");
        Team team3 = new Team("first");
        Team team4 = new Team("second");
        Team team5 = new Team("second");

        ArrayList<String> firstMembers = new ArrayList<>();
        firstMembers.add("John");
        firstMembers.add("Ruth");
        firstMembers.add("Vivian");
        firstMembers.add("Kevin");
        firstMembers.add("Smith");
        firstMembers.add("Gordon");

        ArrayList<String> secondMembers = new ArrayList<>();
        firstMembers.add("John");
        firstMembers.add("Ruth");
        firstMembers.add("Vivian");
        firstMembers.add("Kevin");
        firstMembers.add("Smith");
        firstMembers.add("spaghetti");     // difference

        team1.setMembers(firstMembers);
        team2.setMembers(firstMembers); // same name, same members
        team3.setMembers(secondMembers); // same name, different members
        team4.setMembers(firstMembers); // different name, same members
        team5.setMembers(secondMembers); // different name, different members

        // same name, same members --> true
        assertEquals(team1.equals(team2), true);

        // same name, different members --> false
        assertEquals(team1.equals(team3), false);

        // different name --> always false
        assertEquals(team1.equals(team4), false);
        assertEquals(team1.equals(team5), false);
    }
}
