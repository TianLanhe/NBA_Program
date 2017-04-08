package model;

import java.util.LinkedList;
import java.util.List;

public class Player {
  private String name;//��Ա����
  private int birth_year;//��Ա�������
  private List<Season> seasons;//��Ա�μӹ��������б�


  public Player(String name, int birth_year) {
    this.name = name;
    this.birth_year = birth_year;
    seasons = new LinkedList<Season>();
  }

  public Player() {
    this("", 0);
  }

  public void addSeason(Season season) {
    seasons.add(season);
  }

  public void setBirth(int year) {
    birth_year = year;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getBirth() {
    return birth_year;
  }

  public List<Season> getSeasons() {
    return seasons;
  }
  
  public void setSeasons(List<Season> seasons){
    this.seasons=seasons;
  }
}
