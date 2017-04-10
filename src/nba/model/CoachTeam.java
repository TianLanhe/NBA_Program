package nba.model;

public class CoachTeam {
  private int startYear;// 开始年份
  private int endYear;// 结束年份 [startYear,endYear]
  private String coachName;// 教练
  private String teamName;// 球队

  public CoachTeam(int start, int end, String coach, String team) {
    startYear = start;
    endYear = end;
    this.coachName = coach;
    this.teamName = team;
  }

  public CoachTeam() {
    this(0, 0, "", "");
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj.getClass().equals(this.getClass())) {
      CoachTeam coachTeam = (CoachTeam) obj;
      boolean flag =
          coachTeam.getCoach().equals(coachName) && coachTeam.getTeam().equals(teamName);
      flag = flag && (coachTeam.getEndYear() >= startYear || coachTeam.getStartYear() <= endYear);
      return flag;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + coachName.hashCode();
    result = result * 31 + teamName.hashCode();
    return result;
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

  public String getCoach() {
    return coachName;
  }

  public void setCoach(String coach) {
    this.coachName = coach;
  }

  public String getTeam() {
    return teamName;
  }

  public void setTeam(String team) {
    this.teamName = team;
  }


}
