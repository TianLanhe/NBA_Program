package model;

public class CoachTeam {
  private int startYear;// ��ʼ���
  private int endYear;// �������   [startYear,endYear]
  private Coach coach;// ����
  private Team team;// ���

  public CoachTeam(int start, int end, Coach coach, Team team) {
    startYear = start;
    endYear = end;
    this.coach = coach;
    this.team = team;
  }

  public CoachTeam() {
    this(0, 0, null, null);
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

  public Coach getCoach() {
    return coach;
  }

  public void setCoach(Coach coach) {
    this.coach = coach;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }


}
