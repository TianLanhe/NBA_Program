package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.Player;
import nba.r.R;

import nba.util.NBASearcher;
import nba.window.PlayerDetail;

public class QueryListener implements ActionListener {

  private JTextField textinput;

  public void actionPerformed(ActionEvent arg0) {
    R r = R.getInstance();
    textinput = (JTextField) r.getObject("textPlayer");
    NBASearcher<Player> searcher = new NBASearcher<Player>(Catalog.getInstance().getPlayers());
    if (textinput.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "请输入球员姓名！", "警告", JOptionPane.WARNING_MESSAGE);
    } else {
      Player player = searcher.find("getName", textinput.getText());
      if (player == null) {
        JOptionPane.showMessageDialog(null, "查无此人！", "查找结果", JOptionPane.PLAIN_MESSAGE);
      } else {
        new PlayerDetail(player);
      }
    }
  }

}
