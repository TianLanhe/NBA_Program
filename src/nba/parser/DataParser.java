package nba.parser;

import nba.model.Arena;
import nba.model.ArenaTeam;
import nba.model.Coach;
import nba.model.CoachTeam;
import nba.model.Location;
import nba.model.Player;
import nba.model.Season;
import nba.model.Team;

public class DataParser {

  private String words[];

  private Player player;
  private Team team;
  private Coach coach;
  private Arena arena;
  private CoachTeam coachTeam;
  private ArenaTeam arenaTeam;
  private Location location;
  private Season season;

  public boolean parseData(String string) {
    if (countComma(string) != 23) return false;

    initWords(string);

    parsePlayer();
    parseTeam();
    parseCoach();
    parseArena();
    parseCoachTeam();
    parseArenaTeam();
    parseLocation();
    parseSeason();

    return true;
  }

  // ��һ���ַ��������ŷָ������������24���Ĳ���24��
  private void initWords(String string) {
    words = string.split(",");
    if (words.length != 24) {
      String temp[] = words;
      words = new String[24];
      for (int i = 0; i < temp.length; ++i)
        words[i] = temp[i];
      for (int i = temp.length; i < words.length; ++i)
        words[i] = "";
    }
  }

  // ����һ���ж��ŵ��������Դ˷ֱ������Ƿ�Ϸ�
  private int countComma(String string) {
    int ret = 0;
    for (int i = 0; i < string.length(); ++i)
      if (string.charAt(i) == ',') ++ret;
    return ret;
  }

  private void parseSeason() {
    String start_end = words[2].trim();
    String p = words[7].trim();
    String g = words[6].trim();
    String playerName = words[1].trim();
    String teamAbbr = words[4].trim();
    String age = words[3].trim();


    if (start_end.isEmpty() || p.isEmpty() || g.isEmpty() || playerName.isEmpty()
        || teamAbbr.isEmpty() || age.isEmpty()) {
      season = null;
    } else {
      int year = 0;
      if (start_end.contains("-"))
        year = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1));
      else
        year = Integer.parseInt(start_end);

      int birth = year - Integer.parseInt(age);
      int point = Integer.parseInt(p);
      int game = Integer.parseInt(g);

      season = new Season(playerName, teamAbbr, birth, point, game, year);
    }
  }

  private void parseLocation() {
    String arenaName = words[21].trim();
    String locationName = words[22].trim();
    String start_end = words[20].trim();
    String capacity = words[23].trim();

    if (start_end.isEmpty() || arenaName.isEmpty() || locationName.isEmpty() || capacity.isEmpty()) {
      location = null;
    } else {
      int start, end, capa;
      start = Integer.parseInt(start_end.substring(0, start_end.indexOf("-")));
      end = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1));
      capa = Integer.parseInt(capacity);
      location = new Location(start, end, locationName, arenaName, capa);
    }
  }

  private void parseArenaTeam() {
    String start_end = words[20].trim();
    String arenaName = words[21].trim();
    String teamName = words[19].trim();
    if (start_end.isEmpty() || arenaName.isEmpty() || teamName.isEmpty()) {
      arenaTeam = null;
    } else {
      int start, end;
      start = Integer.parseInt(start_end.substring(0, start_end.indexOf("-")));
      end = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1));

      arenaTeam = new ArenaTeam(start, end, arenaName, teamName);
    }
  }

  private void parseCoachTeam() {
    String start_end = words[8].trim();
    String coachName = words[11].trim();
    String teamName = words[10].trim();

    if (start_end.isEmpty() || coachName.isEmpty() || teamName.isEmpty()) {
      coachTeam = null;
    } else {
      int start, end;
      start = Integer.parseInt(start_end.substring(0, start_end.indexOf("-")));
      end = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1));

      coachTeam = new CoachTeam(start, end, coachName, teamName);
    }
  }

  private void parseArena() {
    String arenaName = words[21].trim();
    String start_end = words[20].trim();

    if (arenaName.isEmpty() || start_end.isEmpty()) {
      arena = null;
    } else {
      int age, birth;
      birth = Integer.parseInt(start_end.substring(0, start_end.indexOf("-")));
      age = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1)) - birth;

      arena = new Arena(arenaName, birth, age);
    }
  }

  private void parseCoach() {
    String coachName = words[11].trim();
    if (coachName.isEmpty()) {
      coach = null;
    } else {
      coach = new Coach(coachName);
    }
  }

  private void parseTeam() {
    int index[] = {4, 10, 12, 14, 15, 16, 18};// ��֤��Щ�ֶ��Ƿ�Ϊ��
    for (int i = 0; i < index.length; ++i) {
      if (words[index[i]].trim().isEmpty()) {
        team = null;
        return;
      }
    }
    String teamName = words[10].trim();
    String teamAbbr = words[4].trim();
    int birth = Integer.parseInt(words[12].trim());
    int year = Integer.parseInt(words[14].trim());
    int game = Integer.parseInt(words[15].trim());
    int win = Integer.parseInt(words[16].trim());
    int champ = Integer.parseInt(words[18].trim());

    team = new Team(teamName, teamAbbr, birth, year, game, win, champ);
  }

  private void parsePlayer() {
    String playerName = words[1].trim();
    String start_end = words[2].trim();
    String age = words[3].trim();

    if (playerName.isEmpty()) {
      player = null;
    } else {
      int year = 0;
      if (start_end.contains("-"))
        year = Integer.parseInt(start_end.substring(start_end.indexOf("-") + 1));
      else
        year = Integer.parseInt(start_end);

      int birth = year - Integer.parseInt(age);

      player = new Player(playerName, birth);
    }
  }

  public Player getPlayer() {
    return player;
  }

  public Team getTeam() {
    return team;
  }

  public Coach getCoach() {
    return coach;
  }

  public Arena getArena() {
    return arena;
  }

  public CoachTeam getCoachTeam() {
    return coachTeam;
  }

  public ArenaTeam getArenaTeam() {
    return arenaTeam;
  }

  public Location getLocation() {
    return location;
  }

  public Season getSeason() {
    return season;
  }
}
