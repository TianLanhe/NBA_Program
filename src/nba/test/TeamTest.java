package nba.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nba.model.Team;

public class TeamTest {
  private static Team team;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    team = new Team("New York Knicks", "NYK", 1947, 68, 5235,2617,2);
  }
  
  @Test
  public void TeamEqualTest(){
    Assert.assertEquals(team, team);
    
    Team team2 = new Team("New York Knicks", "NYK", 1947, 68, 5235,2617,2);
    Assert.assertEquals(team, team2);
    
    team2 = new Team("New York Knicks", "another_teamAbbr", 1947, 68, 5235,2617,2);
    Assert.assertEquals(team, team2);
    
    team2 = new Team("New York Knicks", "NYK", 1947, 47, 5235,2617,2);
    Assert.assertEquals(team, team2);
    
    team2 = new Team("New York Knicks", "NYK", 1947, 68, 4000,2617,2);
    Assert.assertEquals(team, team2);
    
    team2 = new Team("New York Knicks", "NYK", 1947, 68, 5235,2000,2);
    Assert.assertEquals(team, team2);
    
    team2 = new Team("New York Knicks", "NYK", 1947, 68, 5235,2617,0);
    Assert.assertEquals(team, team2);
  }
  
  @Test
  public void TeamNotEqualTest(){
    Team team2 = new Team("another_teamName", "NYK", 1947, 68, 5235,2617,2);
    Assert.assertNotEquals(team, team2);
    
    team2 = new Team("New York Knicks", "NYK", 1948, 68, 5235,2617,2);
    Assert.assertNotEquals(team, team2);
  }
}
