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
import nba.model.Location;
import nba.r.R;
import nba.util.NBAComparator;

public class ArenaCapacityAnalysisListener implements ActionListener {

  private JPanel diagramPanel;
  private JRadioButton btnBar;

  public ArenaCapacityAnalysisListener() {
    R r = R.getInstance();
    diagramPanel = (JPanel) r.getObject("diagramPanel");
    btnBar = (JRadioButton) R.getInstance().getObject("btnBarArena");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    List<Location> locations = new ArrayList<Location>();
    locations.addAll(Catalog.getInstance().getLocations());
    NBAComparator<Location> comparator = new NBAComparator<Location>("getCapacity");
    locations.sort(comparator);

    int capacity = 0;
    int index = -1;
    double[] nums = new double[locations.size()];
    String[] capacities = new String[locations.size()];

    for (Location location : locations) {
      if (capacity != location.getCapacity()) {
        capacity = location.getCapacity();
        ++index;
        capacities[index] = String.valueOf(capacity);
      }
      ++nums[index];
    }

    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];
    System.arraycopy(capacities, 0, keys, 0, index + 1);
    System.arraycopy(nums, 0, values, 0, index + 1);

    String diagramType;
    if (btnBar.isSelected())
      diagramType = "bar";
    else
      diagramType = "pie";

    Diagram b =
        DiagramFactory.createDiagram(diagramType, values, keys, Integer.parseInt(keys[0]), 2000);
    b.setTitle("体育场容量");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("容纳人数");

    diagramPanel.removeAll();
    diagramPanel.add(b.getPanel());
    diagramPanel.validate();
  }
}
