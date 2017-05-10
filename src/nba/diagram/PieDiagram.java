package nba.diagram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.util.TableOrder;

public class PieDiagram extends Diagram {
    private CategoryToPieDataset dataset;

    public PieDiagram(double[] values, String[] keys) {
        super.setCategoryDataset(values, keys);
        dataset = new CategoryToPieDataset(super.getCategoryDataset(), TableOrder.BY_ROW, 0);
    }

    @Override
    protected JFreeChart createDiagram() {
        return ChartFactory.createPieChart(super.getTitle(), dataset);
    }

    public static void main(String[] args) {
        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "ÖÐÎÄ", "banana", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        PieDiagram b = new PieDiagram(dataset, fruits);
        b.draw();
    }
}
