package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import nba.comparator.NBAComparator;
import nba.model.Catalog;
import nba.model.Player;
import nba.window.EachPlayer;

import R.R;

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
//      Allplayer k = new Allplayer();
    } else if (btnDetail.isSelected() & btn != null) {
      Catalog catalog =Catalog.getInstance();
      List<Player> players = catalog.getPlayers();
      EachPlayer l = new EachPlayer(players);
    }
  }
}

//int min = Integet.parseInt(jtextfield.getText());
//int max = Integet.parseInt(jtextfield2.getText());
//for(int i=0;i<players.size();++i)
//  if(players.get(i).getBirth>=min && players.get(i).getBirth<=max)
//    new_list.add(players.get(i))
    
    

    

