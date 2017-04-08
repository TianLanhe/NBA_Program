package model;

import java.util.LinkedList;
import java.util.List;

public class Coach {
  private String name;// ΩÃ¡∑–’√˚
  private List<CoachTeam> coachTeams;

  public Coach(String name) {
    this.name = name;
    coachTeams = new LinkedList<CoachTeam>();
  }

  public Coach() {
    this("");
  }

  public void addCoachTeam(CoachTeam coachTeam) {
    coachTeams.add(coachTeam);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CoachTeam> getCoachTeams() {
    return coachTeams;
  }

  public void setCoachTeams(List<CoachTeam> coachTeams) {
    this.coachTeams = coachTeams;
  }

}
