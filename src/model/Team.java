package model;

import java.util.LinkedList;
import java.util.List;

public class Team {
  private String name; // �������
  private String addreviate;// ��Ӽ��
  private int birth_year;// ��ӵ������
  private int age;// ��Ӵ��ʱ��
  private int game_num;// ��Ӳμӹ��ı�������
  private int win_num;// ���Ӯ��ĳ���
  private int champion_num;// ���Ӯ�ùھ��Ĵ���
  private List<Season> seasons;// �����б�
  private List<CoachTeam> coachTeams;
  private List<ArenaTeam> arenaTeams;

  public Team(String name, String addreviate, int birth_year, int age, int game_num, int win_num,
      int champion_num) {
    this.name = name;
    this.addreviate = addreviate;
    this.birth_year = birth_year;
    this.age = age;
    this.game_num = game_num;
    this.win_num = win_num;
    this.champion_num = champion_num;

    seasons = new LinkedList<Season>();
    coachTeams = new LinkedList<CoachTeam>();
    arenaTeams = new LinkedList<ArenaTeam>();
  }

  public Team() {
    this("", "", 0, 0, 0, 0, 0);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAddr(String addr) {
    addreviate = addr;
  }

  public String getAddr() {
    return addreviate;
  }

  public void setWinNum(int i) {
    win_num = i;
  }

  public int getWinNum() {
    return win_num;
  }

  public void setGameNum(int i) {
    game_num = i;
  }

  public int getGameNum() {
    return game_num;
  }

  public int getBirth() {
    return birth_year;
  }

  public void setBirth(int year) {
    birth_year = year;
  }

  public void setAge(int i) {
    age = i;
  }

  public int getAge() {
    return age;
  }

  public void setChampNum(int i) {
    champion_num = i;
  }

  public int getChampNum() {
    return champion_num;
  }

  public void addSeason(Season season) {
    seasons.add(season);
  }

  public void addCoachTeam(CoachTeam coachTeam) {
    coachTeams.add(coachTeam);
  }

  public void addArenaTeam(ArenaTeam arenaTeam) {
    arenaTeams.add(arenaTeam);
  }

  public List<Season> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<Season> seasons) {
    this.seasons = seasons;
  }

  public void setCoachTeams(List<CoachTeam> coachTeams) {
    this.coachTeams = coachTeams;
  }

  public List<CoachTeam> getCoachTeams() {
    return coachTeams;
  }

  public List<ArenaTeam> getArenaTeams() {
    return arenaTeams;
  }

  public void setArenaTeams(List<ArenaTeam> arenaTeams) {
    this.arenaTeams = arenaTeams;
  }

}
