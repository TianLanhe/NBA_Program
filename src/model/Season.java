package model;

public class Season {
  private Player player;// ����������Ա
  private Team team;// �����������
  private int point;// �������÷�
  private int game_num;// �������μӵĳ���
  private int year;// ��������ݣ������꣩

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
