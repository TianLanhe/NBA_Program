package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import nba.r.R;

import nba.model.Catalog;
import nba.model.Player;
import nba.window.EachPlayer;

public class ClickBtnListener implements ActionListener {
  private JRadioButton btnAnalysis, btnDetail;
  private JButton btn;

  public ClickBtnListener() {

    R r = R.getInstance();
    btnAnalysis = (JRadioButton) r.getObject("btnAnalysis");
    btnDetail = (JRadioButton) r.getObject("btnDetail");
    btn = (JButton) r.getObject("btnPlayer");
  }

  public void actionPerformed(ActionEvent e) {

    if (btnAnalysis.isSelected() && btn != null) {
      // Allplayer k = new Allplayer();
    } else if (btnDetail.isSelected() & btn != null) {
      Catalog catalog = Catalog.getInstance();
      List<Player> players = catalog.getPlayers();
      EachPlayer l = new EachPlayer(players);
    }
  }
}



