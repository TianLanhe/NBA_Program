package model;

public class Season {
  private Player player;// 赛季所属球员
  private Team team;// 赛季所属球队
  private int point;// 该赛季得分
  private int game_num;// 该赛季参加的场数
  private int year;// 该赛季年份（结束年）

  public Season(Player player, Team team, int point, int game_num, int year) {
    this.player = player;
    this.team = team;
    this.point = point;
    this.game_num = game_num;
    this.year = year;
  }

  public Season() {
    this(null, null, 0, 0, 0);
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public int getGameNum() {
    return game_num;
  }

  public void setGameNum(int game_num) {
    this.game_num = game_num;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
