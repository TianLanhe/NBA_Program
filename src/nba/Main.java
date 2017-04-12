package nba;

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

public class Main {
  public static void main(String[] argv) {
    DataLoader dataLoader = new DataLoader();
    DataParser dataParser = new DataParser();
    // if (!dataLoader.loadFrom("NBA_data.txt")) { // 打開文件
    // return;
    // }
    // Catalog catalog = Catalog.getInstance();
    // while (dataLoader.hasNext()) {
    // String string = dataLoader.next(); // 連續讀取每一行
    // if (!dataParser.parseData(string)) { // 交給解析器解析，解析器解析出每個對象
    // System.out.println("no");
    // return;
    // }
    //
    // catalog.addPlayer(dataParser.getPlayer());
    // catalog.addArena(dataParser.getArena());
    // catalog.addArenaTeam(dataParser.getArenaTeam());
    // catalog.addTeam(dataParser.getTeam());
    // catalog.addCoach(dataParser.getCoach());
    // catalog.addCoachTeam(dataParser.getCoachTeam());
    // catalog.addLocation(dataParser.getLocation());
    // catalog.addSeason(dataParser.getSeason());
    // }
    // System.out.println("Players: "+catalog.getPlayers().size());
    // System.out.println("Seasons: "+catalog.getSeasons().size());
    // System.out.println("Teams: "+catalog.getTeams().size());
    // System.out.println("Coachs: "+catalog.getCoachs().size());
    // System.out.println("CoachTeams: "+catalog.getCoachTeams().size());
    // System.out.println("Arenas: "+catalog.getArenas().size());
    // System.out.println("ArenaTeams: "+catalog.getArenaTeams().size());
    // System.out.println("Locations: "+catalog.getLocations().size());
    new DataLoadingControler(dataLoader, dataParser).loadData("NBA_data.txt");
    List<Coach> coachs = Catalog.getInstance().getCoachs();
    int count_coath_to_team = 0;
    for (Coach coach : coachs)
      count_coath_to_team += coach.getCoachTeams().size();
    System.out.println("count_coach_to_team: " + count_coath_to_team);
    
    List<Team> teams = Catalog.getInstance().getTeams();
    int count_team_to_coach =0;
    int count_team_to_arena = 0;
    for (Team team : teams){
      count_team_to_coach += team.getCoachTeams().size();
      count_team_to_arena += team.getArenaTeams().size();
    }
    System.out.println("count_team_to_coach: " + count_team_to_coach);
    System.out.println("count_team_to_arena: " + count_team_to_arena);
    
    List<Arena> arenas = Catalog.getInstance().getArenas();
    int count_arena_to_team = 0;
    int count_arena_to_location = 0;
    for(Arena arena:arenas){
      count_arena_to_team += arena.getArenaTeams().size();
      count_arena_to_location += arena.getLocations().size();
    }
    System.out.println("count_arena_to_team: " + count_arena_to_team);
    System.out.println("count_arena_to_location: " + count_arena_to_location);
  }
}
