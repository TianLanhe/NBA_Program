package nba.window;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import nba.model.Player;
import nba.model.Season;


public class PlayerDetail extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JTextField playerNameTx;
  private JTextField playerBirthTx;
  private JTable table;
  private Player player;
  private List<Season> seasons;



  public PlayerDetail(Player player) {
    super();
    setTitle("球员详细信息");

    this.player = player;
    seasons = player.getSeasons();

    setPlayerName();
    setPlayerBirth();
    fillTable();
  }


  private void setPlayerBirth() {
    String str = player.getBirth() + "";
    playerBirthTx.setText(str);
  }


  private void setPlayerName() {
    playerNameTx.setText(player.getName());
  }

  @Override
  protected void addListener() {

  }

  @Override
  protected void init() {
    setLayout(null);

    JLabel name = new JLabel("球员名字：");
    name.setBounds(20, 20, 100, 40);
    add(name);

    playerNameTx = new JTextField();
    playerNameTx.setBounds(110, 28, 160, 25);
    add(playerNameTx);

    JLabel birth = new JLabel("球员出生年份：");
    birth.setBounds(20, 70, 100, 40);
    add(birth);

    playerBirthTx = new JTextField();
    playerBirthTx.setBounds(110, 78, 160, 25);
    add(playerBirthTx);

    JLabel gameInformation = new JLabel("参赛信息：");
    gameInformation.setBounds(20, 120, 100, 40);
    add(gameInformation);

    // table = new JTable();
    // table.setBounds(100, 100, 200, 400);
    // JScrollPane JSP = new JScrollPane(table);
    // JSP.setBounds(110, 130, 500, 400);
    // add(JSP);
  }

  public void fillTable() {
    String[][] data = new String[seasons.size()][4];
    String[] columnNames = {"赛季", "参赛场次", "得分", "所属球队缩写"};

    for (int i = 0; i < data.length; ++i) {
      Season s = seasons.get(i);
      data[i][0] = s.getYear() - 1 + "-" + s.getYear();
      data[i][1] = s.getGameNum() + "";
      data[i][2] = s.getPoint() + "";
      data[i][3] = s.getTeamAbbr();
    }

    table = new JTable(data, columnNames);
    JScrollPane JSP = new JScrollPane(table);
    JSP.setBounds(110, 130, 500, 400);
    add(JSP);
  }

  @Override
  protected void regitstComponent() {

  }
}
