package nba.model;

public class ArenaTeam {
  private String arenaName;// ��
  private String teamName;// ���
  private int startYear;// ��ʼ���
  private int endYear;// ������� [startYear,endYear]

  public ArenaTeam(int start, int end, String arena, String team) {
    startYear = start;
    endYear = end;
    this.arenaName = arena;
    this.teamName = team;
  }

  public ArenaTeam() {
    this(0, 0, "", "");
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj.getClass().equals(this.getClass())) {
      ArenaTeam arenaTeam = (ArenaTeam) obj;
      boolean flag = arenaTeam.getArena().equals(arenaName) && arenaTeam.getTeam().equals(teamName);
      flag = flag && isIntersect(arenaTeam);
      return flag;
    }
    return false;
  }

  // �ж��������������Ƿ��н���
  private boolean isIntersect(ArenaTeam arenaTeam) {
    return isIntersect(startYear, endYear, arenaTeam.getStartYear(), arenaTeam.getEndYear());
  }

  private boolean isIntersect(int start1, int end1, int start2, int end2) {
    boolean flag = false;
    flag = flag || (start1 >= start2 && start1 <= end2);
    flag = flag || (end1 >= start2 && end1 <= end2);
    flag = flag || (start1 < start2 && end1 > end2);
    return flag;
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
