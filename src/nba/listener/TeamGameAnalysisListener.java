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

import nba.model.Team;
import nba.r.R;
import nba.util.NBAComparator;

public class TeamGameAnalysisListener implements ActionListener {

  private JPanel diagramPanel;
  private JRadioButton btnBar;

  public TeamGameAnalysisListener() {
    R r = R.getInstance();
    diagramPanel = (JPanel) r.getObject("teamDiagramPanel");
    btnBar = (JRadioButton) R.getInstance().getObject("btnBarTeam");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    List<Team> teams = new ArrayList<Team>();
    teams.addAll(Catalog.getInstance().getTeams());
    NBAComparator<Team> comparator = new NBAComparator<Team>("getGameNum");
    teams.sort(comparator);

    double[] nums = new double[teams.size()];
    String[] games = new String[teams.size()];
    int game = 0;
    int index = -1;
    for (Team team : teams) {
      if (game != team.getGameNum()) {
        game = team.getGameNum();
        ++index;
        games[index] = String.valueOf(game);
      }
      ++nums[index];
    }

    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];
    System.arraycopy(games, 0, keys, 0, index + 1);
    System.arraycopy(nums, 0, values, 0, index + 1);

    String diagramType;
    if (btnBar.isSelected())
      diagramType = "bar";
    else
      diagramType = "pie";

    Diagram b =
        DiagramFactory.createDiagram(diagramType, values, keys, Integer.parseInt(keys[0]), 300);
    b.setTitle("球队参赛场次分布");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("参赛场次");

    diagramPanel.removeAll();
    diagramPanel.add(b.getPanel());
    diagramPanel.validate();
  }
}
