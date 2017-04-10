package nba;

import nba.controler.DataLoadingControler;
import nba.loader.DataLoader;
import nba.model.Catalog;
import nba.model.Location;
import nba.parser.DataParser;

public class Main {
  public static void main(String[] argv) {
    DataLoader dataLoader = new DataLoader();
    DataParser dataParser = new DataParser();
    if (!dataLoader.loadFrom("NBA_data.txt")) { // 打開文件
      return;
    }
    Catalog catalog = Catalog.getInstance();
    while (dataLoader.hasNext()) {
      String string = dataLoader.next(); // 連續讀取每一行
      if (!dataParser.parseData(string)) { // 交給解析器解析，解析器解析出每個對象
        System.out.println("no");
        return;
      }

      catalog.addPlayer(dataParser.getPlayer());
      catalog.addArena(dataParser.getArena());
      catalog.addArenaTeam(dataParser.getArenaTeam());
      catalog.addTeam(dataParser.getTeam());
      catalog.addCoach(dataParser.getCoach());
      catalog.addCoachTeam(dataParser.getCoachTeam());
      catalog.addLocation(dataParser.getLocation());
      catalog.addSeason(dataParser.getSeason());
    }
    System.out.println("Players: "+catalog.getPlayers().size());
    System.out.println("Seasons: "+catalog.getSeasons().size());
    System.out.println("Teams: "+catalog.getTeams().size());
    System.out.println("Coachs: "+catalog.getCoachs().size());
    System.out.println("CoachTeams: "+catalog.getCoachTeams().size());
    System.out.println("Arenas: "+catalog.getArenas().size());
    System.out.println("ArenaTeams: "+catalog.getArenaTeams().size());
    System.out.println("Locations: "+catalog.getLocations().size());
  }
}
