package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;

import nba.model.ArenaTeam;
import nba.model.Catalog;

import nba.r.R;
import nba.util.NBAComparator;

public class ArenaAgeAnalysisListener implements ActionListener {

  private JPanel diagramPanel;
  private JRadioButton btnBar;

  public ArenaAgeAnalysisListener() {
    R r = R.getInstance();
    diagramPanel = (JPanel) r.getObject("diagramPanel");
    btnBar = (JRadioButton) R.getInstance().getObject("btnBarArena");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    Catalog catalog = Catalog.getInstance();
    List<ArenaTeam> arenaTeams = new ArrayList<ArenaTeam>();
    arenaTeams.addAll(catalog.getArenaTeams());

    NBAComparator<ArenaTeam> comparator = // 按成立年份从大到小排序
        new NBAComparator<ArenaTeam>("getStartYear", NBAComparator.FROM_BIG);
    arenaTeams.sort(comparator);

    int index = -1;
    int startYear = 0;
    double[] num = new double[arenaTeams.size()];
    String[] age = new String[arenaTeams.size()];

    for (ArenaTeam arenaTeam : arenaTeams) { // 统计所有体育场年限分布
      if (startYear != arenaTeam.getStartYear()) {
        startYear = arenaTeam.getStartYear();
        ++index;
        age[index] = String.valueOf(2017 - startYear);
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
    b.setTitle("体育场使用年限");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("年限");

    diagramPanel.removeAll();
    diagramPanel.add(b.getPanel());
    diagramPanel.validate();
  }
}
