package nba;

import java.util.Collections;
import java.util.List;

import nba.comparator.NBAComparator;
import nba.controler.DataLoadingControler;
import nba.loader.DataLoader;
import nba.model.Arena;
import nba.model.Catalog;
import nba.model.Coach;
import nba.model.Player;
import nba.model.Team;
import nba.parser.DataParser;
import nba.window.HomePage;

public class Main {
  public static void main(String[] argv) {
    new HomePage();
//    DataLoader dataLoader = new DataLoader();
//    DataParser dataParser = new DataParser();
//    DataLoadingControler dataLoadingControler = new DataLoadingControler(dataLoader, dataParser);
//    
//    if(!dataLoadingControler.loadData("NBA_data.txt"))
//      System.exit(1);
//    
//    Catalog catalog = Catalog.getInstance();
//
//    List<Player> players = catalog.getPlayers();
//    
//    //≈≈–Ú
//    NBAComparator<Player> comparator = new NBAComparator<Player>("getName",NBAComparator.FROM_BIG);
//    
//    Collections.sort(players,comparator);
    
    
  }
}
