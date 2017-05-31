package nba.diagram;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;

public class SpiderDiagram extends Diagram {

    public SpiderDiagram(double[] values, String[] keys) {
        super.setCategoryDataset(values, keys);
    }

    @Override
    protected JFreeChart createDiagram() {
        SpiderWebPlot spiderwebplot = new SpiderWebPlot(super.categoryDataset);
        return new JFreeChart(super.title, spiderwebplot);
    }
}
