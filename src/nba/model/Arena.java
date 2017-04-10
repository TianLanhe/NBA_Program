package nba.model;

import java.util.LinkedList;
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
    arenaTeams = new LinkedList<ArenaTeam>();
    locations = new LinkedList<Location>();
  }

  public Arena() {
    this("", 0, 0);
  }

  public void addArenaTeam(ArenaTeam arenaTeam) {
    if (arenaTeam != null && !arenaTeams.contains(arenaTeam)) arenaTeams.add(arenaTeam);
  }

  public void addLocation(Location location) {
    if (location != null && !locations.contains(location)) locations.add(location);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj.getClass().equals(this.getClass())) {
      Arena arena = (Arena) obj;
      return arena.getName().equals(name) && arena.getBirth() == birth;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + name.hashCode();
    result = result * 31 + birth;
    return result;
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

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }
}
