package nba.model;

public class Location {
  private String name;// ���c��
  private int startYear;// �_ʼ�r�g
  private int endYear;// �Y���r�g [startYear,endYear]
  private int capacity;// ����
  private String arenaName;// �w������

  public Location(int start, int end, String name, String arenaName, int capacity) {
    startYear = start;
    endYear = end;
    this.name = name;
    this.capacity = capacity;
    this.arenaName = arenaName;
  }

  public Location() {
    this(0, 0, "", "", 0);
  }

  @Override
  public boolean equals(Object obj) { // ������λ�õĵص㡢������������ͬ�������ཻ���ʱ����Ϊ����λ����ȣ����Ժϲ���
    if (obj != null && obj.getClass().equals(this.getClass())) {
      Location location = (Location) obj;
      boolean flag =
          location.getName().equals(name) && location.getCapacity() == capacity
              && location.getArenaName().equals(arenaName);
      flag = flag && (location.getEndYear() >= startYear || location.getStartYear() <= endYear);
      return flag;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + name.hashCode();
    result = result * 31 + arenaName.hashCode();
    result = result * 31 + capacity;
    return result;
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

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getArenaName() {
    return arenaName;
  }

  public void setArenaName(String arenaName) {
    this.arenaName = arenaName;
  }
}
