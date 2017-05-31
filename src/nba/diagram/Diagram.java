package nba.diagram;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public abstract class Diagram {

    private JFreeChart diagram;
    protected String frameTitle = "Í³¼ÆÍ¼";
    protected String title = "";
    protected String categoryAxisLabel = "";
    protected String valueAxisLabel = "";
    
    protected DefaultCategoryDataset categoryDataset;

    public DefaultCategoryDataset getCategoryDataset() {
        return categoryDataset;
    }

    protected abstract JFreeChart createDiagram();

    public void setCategoryDataset(double[] values, String[] keys) {
        if (values.length != keys.length) {
            System.out.println("Error! Length of each paramter is not equal!");
            System.exit(0);
        }

        categoryDataset = new DefaultCategoryDataset();

        for (int i = 0; i < values.length; ++i) {
            categoryDataset.addValue(values[i], "", keys[i]);
        }
    }

    public void draw() {

        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setExtraLargeFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));       // ÉèÖÃ±êÌâ×ÖÌå
        mChartTheme.setLargeFont(new Font("Î¢ÈíÑÅºÚ", Font.CENTER_BASELINE, 12)); // ÉèÖÃÖáÏò×ÖÌå
        mChartTheme.setRegularFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));         // ÉèÖÃÍ¼Àý×ÖÌå
        ChartFactory.setChartTheme(mChartTheme);

        diagram = createDiagram();
        diagram.removeLegend();

        ChartFrame frame = new ChartFrame(frameTitle, diagram, true);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getFrameTitle() {
        return frameTitle;
    }

    public void setFrameTitle(String frameTitle) {
        this.frameTitle = frameTitle;
    }

    public String getCategoryAxisLabel() {
        return categoryAxisLabel;
    }

    public void setCategoryAxisLabel(String categoryAxisLabel) {
        this.categoryAxisLabel = categoryAxisLabel;
    }

    public String getValueAxisLabel() {
        return valueAxisLabel;
    }

    public void setValueAxisLabel(String valueAxisLabel) {
        this.valueAxisLabel = valueAxisLabel;
    }


}
