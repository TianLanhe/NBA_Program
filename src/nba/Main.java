package nba;

import nba.controler.DataLoadingControler;
import nba.loader.DataLoader;
import nba.model.Catalog;
import nba.model.Location;
import nba.parser.DataParser;

public class Main {
  public static void main(String[] argv) {
    DataLoader dataLoader = new DataLoader();
    DataParser dataParser = new DataParser();
    if (!dataLoader.loadFrom("NBA_data.txt")) { // ���_�ļ�
      return;
    }
    Catalog catalog = Catalog.getInstance();
    while (dataLoader.hasNext()) {
      String string = dataLoader.next(); // �B�m�xȡÿһ��
      if (!dataParser.parseData(string)) { // ���o������������������������ÿ������
        System.out.println("no");
        return;
      }

      catalog.addLocation(dataParser.getLocation());
    }
  }
}
