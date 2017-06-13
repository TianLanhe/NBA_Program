package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;
import nba.model.Catalog;
import nba.model.Player;
import nba.r.R;
import nba.util.NBAComparator;

public class PlayerAgeAnalysisListener implements ActionListener {

  private JPanel diagramPanel;
  private JRadioButton btnBar;

  public PlayerAgeAnalysisListener() {
    R r = R.getInstance();
    diagramPanel = (JPanel) r.getObject("playerDiagramPanel");
    btnBar = (JRadioButton) R.getInstance().getObject("btnBar");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    Catalog catalog = Catalog.getInstance();
    List<Player> players = new ArrayList<Player>();
    players.addAll(catalog.getPlayers());

    NBAComparator<Player> comparator = // 按生日从大到小排序
        new NBAComparator<Player>("getBirth", NBAComparator.FROM_BIG);
    players.sort(comparator);

    int index = -1;
    int birth = 0;
    double[] num = new double[players.size()];
    String[] age = new String[players.size()];
    for (Player player : players) { // 统计所有球员年龄分布
      if (birth != player.getBirth()) {
        birth = player.getBirth();
        ++index;
        age[index] = String.valueOf(2017 - birth);
      }
      ++num[index];
    }

    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];

    System.arraycopy(age, 0, keys, 0, index + 1);
    System.arraycopy(num, 0, values, 0, index + 1);

    String diagramType;
    if (btnBar.isSelected())
      diagramType = "bar";
    else
      diagramType = "pie";

    Diagram b =
        DiagramFactory.createDiagram(diagramType, values, keys, Integer.parseInt(keys[0]), 10);
    b.setTitle("球员年限分布");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("年龄");

    diagramPanel.removeAll();
    diagramPanel.add(b.getPanel());
    diagramPanel.validate();
  }
}
