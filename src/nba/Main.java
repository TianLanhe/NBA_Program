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
    if (!dataLoader.loadFrom("NBA_data.txt")) { // 打開文件
      return;
    }
    Catalog catalog = Catalog.getInstance();
    while (dataLoader.hasNext()) {
      String string = dataLoader.next(); // 連續讀取每一行
      if (!dataParser.parseData(string)) { // 交給解析器解析，解析器解析出每個對象
        System.out.println("no");
        return;
      }

      catalog.addLocation(dataParser.getLocation());
    }
  }
}
