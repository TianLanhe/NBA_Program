package nba.diagram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

public class LineDiagram extends Diagram {

    public LineDiagram(double[] values, String[] keys) {
        super.setCategoryDataset(values, keys);
    }

    @Override
    protected JFreeChart createDiagram() {
        return ChartFactory.createLineChart(super.getTitle(), super.getCategoryAxisLabel(), super.getValueAxisLabel(), super.getCategoryDataset());
    }

    public static void main(String[] args) {
        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "apple", "banana", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        LineDiagram b = new LineDiagram(dataset, fruits);
        b.draw();
    }
}
