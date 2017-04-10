package nba.model;

public class ArenaTeam {
  private String arenaName;// 球场
  private String teamName;// 球队
  private int startYear;// 开始年份
  private int endYear;// 结束年份 [startYear,endYear]

  public ArenaTeam(int start, int end, String arena, String team) {
    startYear = start;
    endYear = end;
    this.arenaName = arena;
    this.teamName = team;
  }

  public ArenaTeam() {
    this(0, 0, "","");
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj.getClass().equals(this.getClass())) {
      ArenaTeam arenaTeam = (ArenaTeam) obj;
      boolean flag = arenaTeam.getArena().equals(arenaName) && arenaTeam.getTeam().equals(teamName);
      flag = flag && (arenaTeam.getEndYear() >= startYear || arenaTeam.getStartYear() <= endYear);
      return flag;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + arenaName.hashCode();
    result = result * 31 + teamName.hashCode();
    return result;
  }


  public String getArena() {
    return arenaName;
  }

  public void setArena(String arena) {
    this.arenaName = arena;
  }

  public String getTeam() {
    return teamName;
  }

  public void setTeam(String team) {
    this.teamName = team;
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
