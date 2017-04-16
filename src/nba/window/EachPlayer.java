package nba.window;

import java.awt.*;
import javax.swing.*;

import nba.r.R;
import nba.listener.QueryListener;
import nba.model.Catalog;
import nba.model.Player;

import java.util.List;

public class EachPlayer extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JTextField textPlayer;// 输入搜索内容
  private JButton btnPlayerEnsure;// "确定搜索"按钮
  private List<Player> players;

  public EachPlayer(List<Player> players) {
    super();
    setTitle("球员详细信息");
    setSize(880, 610);
    this.players = players;
  }

  protected void init() {
    setLayout(new FlowLayout());

    add(new JLabel("搜索："));
    textPlayer = new JTextField(58);
    add(textPlayer);

    btnPlayerEnsure = new JButton("确定");
    add(btnPlayerEnsure);

    players = Catalog.getInstance().getPlayers();
    String[][] name = new String[players.size() / 8 + 1][8];
    for (int i = 0; i < name.length; ++i) {
      for (int j = 0; j < name[0].length; ++j) {
        if (i * 8 + j == players.size()) break;
        name[i][j] = players.get(i * 8 + j).getName();
      }
    }
    String[] title = {"A", "B", "C", "D", "E", "F", "G", "H"};
    JTable initTable = new JTable(name, title);
    initTable.setPreferredScrollableViewportSize(new Dimension(750, 500));
    initTable.setRowHeight(30);

    add(new JScrollPane(initTable));
  }



  protected void addListener() {
    btnPlayerEnsure.addActionListener(new QueryListener());
  }


  protected void regitstComponent() {
    R.getInstance().registObject("textPlayer", textPlayer);
  }

}
