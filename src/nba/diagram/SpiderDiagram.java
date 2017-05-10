package nba.diagram;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;

public class SpiderDiagram extends Diagram {

    public SpiderDiagram(double[] values, String[] keys) {
        super.setCategoryDataset(values, keys);
    }

    @Override
    protected JFreeChart createDiagram() {
        SpiderWebPlot spiderwebplot = new SpiderWebPlot(super.getCategoryDataset());
        return new JFreeChart(super.getTitle(), spiderwebplot);
    }

    public static void main(String[] args) {
        double[] values = { 5, 6, 4, 2, 5, 5, 5, 8 };
        String[] keys = { "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8"};
        SpiderDiagram s = new SpiderDiagram(values, keys);
        s.draw();
    }

}
