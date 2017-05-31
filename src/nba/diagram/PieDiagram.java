package nba.diagram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.util.TableOrder;

public class PieDiagram extends Diagram {
  private CategoryToPieDataset dataset;

  public PieDiagram(double[] values, String[] keys) {
    super.setCategoryDataset(values, keys);
    dataset = new CategoryToPieDataset(super.categoryDataset, TableOrder.BY_ROW, 0);
  }

  @Override
  protected JFreeChart createDiagram() {
    return ChartFactory.createPieChart(super.getTitle(), dataset);
  }
}
