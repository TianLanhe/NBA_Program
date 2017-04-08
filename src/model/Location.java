package model;

public class Location {
  private String name;
  private int startYear;
  private int endYear;
  private int capicity;

  public Location(int start, int end, String name, int capicity) {
    startYear = start;
    endYear = end;
    this.name = name;
    this.capicity = capicity;
  }

  public Location() {
    this(0, 0, "", 0);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public int getCapicity() {
    return capicity;
  }

  public void setCapicity(int capicity) {
    this.capicity = capicity;
  }
}
