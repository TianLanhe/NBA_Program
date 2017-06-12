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
import nba.model.Season;
import nba.r.R;
import nba.util.NBAComparator;

public class PlayerSeasonAnalysisListener implements ActionListener {

  private JPanel diagramPanel;
  private JRadioButton btnBar;

  public PlayerSeasonAnalysisListener() {
    R r = R.getInstance();
    diagramPanel = (JPanel) r.getObject("playerDiagramPanel");
    btnBar = (JRadioButton) R.getInstance().getObject("btnBar");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    List<Season> seasons = new ArrayList<Season>();
    seasons.addAll(Catalog.getInstance().getSeasons());
    NBAComparator<Season> comparator = new NBAComparator<Season>("getYear");
    seasons.sort(comparator);

    double[] nums = new double[seasons.size()];
    String[] years = new String[seasons.size()];
    int year = 0;
    int index = -1;
    for (Season season : seasons) {
      if (year != season.getYear()) {
        year = season.getYear();
        ++index;
        years[index] = String.valueOf(year);
      }
      ++nums[index];
    }

    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];
    System.arraycopy(years, 0, keys, 0, index + 1);
    System.arraycopy(nums, 0, values, 0, index + 1);

    String diagramType;
    if (btnBar.isSelected())
      diagramType = "bar";
    else
      diagramType = "pie";

    Diagram b = DiagramFactory.createDiagram(diagramType, values, keys, 1946, 10);
    b.setTitle("球员参赛赛季分布");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("参赛季度");

    diagramPanel.removeAll();
    diagramPanel.add(b.getPanel());
    diagramPanel.validate();
  }
}
