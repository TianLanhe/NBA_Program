package nba.test;

import nba.model.Player;
import nba.model.Season;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
  
  private static Player player1;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    player1 = new Player("Name1",1996);
  }
  
  @Test
  public void PlayerEqualTest() {
    Player player2 = new Player("Name1",1996);
    Assert.assertEquals(player1, player2);
    Assert.assertEquals(player1, player1);
  }
  
  @Test
  public void PlayerNotEqualTest(){
    Player player2 = new Player("Name1",1995);
    Assert.assertNotEquals(player1, player2);
    
    player2 = new Player("Name2",1996);
    Assert.assertNotEquals(player1, player2);
    
    player2 = new Player();
    Assert.assertNotEquals(player1, player2);
  }
  
  @Test
  public void PlayerAddSeasonTest(){
    player1.addSeason(new Season());
    Assert.assertEquals(player1.getSeasons().size(), 1);
    
    player1.addSeason(new Season());    //添加相同的不予理会
    Assert.assertEquals(player1.getSeasons().size(), 1);
  }
}
