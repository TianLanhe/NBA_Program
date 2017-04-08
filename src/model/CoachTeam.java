package model;

public class CoachTeam {
  private int startYear;// 开始年份
  private int endYear;// 结束年份   [startYear,endYear]
  private Coach coach;// 教练
  private Team team;// 球队

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
