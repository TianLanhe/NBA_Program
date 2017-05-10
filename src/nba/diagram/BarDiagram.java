package nba.diagram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

public class BarDiagram extends Diagram {

    public BarDiagram(double[] values, String[] keys) {
        super.setCategoryDataset(values, keys);
    }

    @Override
    protected JFreeChart createDiagram() {
        return ChartFactory.createBarChart(super.getTitle(), super.getCategoryAxisLabel(), super.getValueAxisLabel(),
                super.getCategoryDataset());
    }

    public static void main(String[] args) {

        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "apple", "Ӧ��", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        BarDiagram b = new BarDiagram(dataset, fruits);
        b.setTitle(new String("ͳ��ͼ"));
        b.draw();

    }

}
