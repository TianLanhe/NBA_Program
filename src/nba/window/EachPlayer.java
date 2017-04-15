package nba.window;

import java.awt.*;
import javax.swing.*;

import nba.r.R;

import nba.comparator.NBAComparator;
import nba.model.Player;

import java.util.Collections;
import java.util.List;


public class EachPlayer extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JTextField textPlayer;
  private JButton btnPlayerEnsure;
  private JTextArea areaPlayer;
  private JScrollPane spPlayer;
  private List<Player> players;

  public EachPlayer(List<Player> players) {
    super();
    setTitle("球员详细信息");
    setSize(880, 610);
    this.players=players;
    setTextAreaContent();
  }

  private void setTextAreaContent() {
   // NBAComparator<Player> comparator = new NBAComparator<Player>("getBirth");
    //Collections.sort(players,comparator);
    for(Player player:players)
      areaPlayer.append(player.getName()+"\n");
    
  }

  protected void addListener() {

  }

  protected void regitstComponent() {
    R r = R.getInstance();
    r.registObject("textPlayer", textPlayer);
    r.registObject("btnPlayerEnsure", btnPlayerEnsure);
    r.registObject("areaPlayer", areaPlayer);
    r.registObject("spPlayer", spPlayer);
  }

  protected void init() {
    setLayout(new FlowLayout());
    add(new JLabel("搜索："));
    textPlayer = new JTextField(58);
    add(textPlayer);
    btnPlayerEnsure = new JButton("确定");
    add(btnPlayerEnsure);
    areaPlayer = new JTextArea(25, 68);
    add(areaPlayer);
    spPlayer = new JScrollPane(areaPlayer);
    add(spPlayer);

  }

}
