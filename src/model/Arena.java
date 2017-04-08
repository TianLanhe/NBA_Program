package model;

import java.util.List;

public class Arena {
  private String name;
  private int birth;
  private int age;
  private List<ArenaTeam> arenaTeams;
  private List<Location> locations;

  public Arena(String name, int birth, int age) {
    this.name = name;
    this.birth = birth;
    this.age = age;
  }

  public Arena() {
    this("", 0, 0);
  }

  public void addArenaTeam(ArenaTeam arenaTeam) {
    arenaTeams.add(arenaTeam);
  }

  public void addLocation(Location location) {
    locations.add(location);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirth() {
    return birth;
  }

  public void setBirth(int birth) {
    this.birth = birth;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<ArenaTeam> getArenaTeams() {
    return arenaTeams;
  }

  public void setArenaTeams(List<ArenaTeam> arenaTeams) {
    this.arenaTeams = arenaTeams;
  }
}
