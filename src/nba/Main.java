package nba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nba.controler.DataLoadingControler;
import nba.loader.DataLoader;
import nba.model.Arena;
import nba.model.Catalog;
import nba.model.Coach;
import nba.model.Player;
import nba.model.Team;
import nba.parser.DataParser;
import nba.util.NBAComparator;
import nba.util.NBASearcher;
import nba.window.HomePage;

public class Main {
  public static void main(String[] argv) {
    new HomePage();
  }
}
