package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JRadioButton;

import nba.r.R;

import nba.model.Catalog;
import nba.model.Player;
import nba.window.Allplayer;
import nba.window.EachPlayer;

public class ClickBtnListener implements ActionListener {
  private JRadioButton btnAnalysis;

  public ClickBtnListener() {
    R r = R.getInstance();
    btnAnalysis = (JRadioButton) r.getObject("btnAnalysis");
  }

  public void actionPerformed(ActionEvent e) {

    if (btnAnalysis.isSelected()) {
      new Allplayer();
    } else {
      Catalog catalog = Catalog.getInstance();
      List<Player> players = catalog.getPlayers();
      new EachPlayer(players);
    }
  }
}
