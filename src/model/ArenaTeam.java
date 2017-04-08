package model;

public class ArenaTeam {
  private Arena arena;// ��
  private Team team;// ���
  private int startYear;// ��ʼ���
  private int endYear;// ������� [startYear,endYear]

  public ArenaTeam(int start, int end, Arena arena, Team team) {
    startYear = start;
    endYear = end;
    this.arena = arena;
    this.team = team;
  }

  public ArenaTeam() {
    this(0, 0, null, null);
  }

  public Arena getArena() {
    return arena;
  }

  public void setArena(Arena arena) {
    this.arena = arena;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(int startYear) {
    this.startYear = startYear;
  }

  public int getEndYear() {
    return endYear;
  }

  public void setEndYear(int endYear) {
    this.endYear = endYear;
  }

}
