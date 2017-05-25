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
    private String frameTitle = "Í³¼ÆÍ¼";
    private String title = "";
    private String categoryAxisLabel = "";
    private String valueAxisLabel = "";
    
    private DefaultCategoryDataset categoryDataset;

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

    public static void main(String[] args) {
        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "Æ»¹û", "Ïã½¶", "ÄûÃÊ", "³È×Ó", "Î÷¹Ï", "ÌÒ×Ó", "Ó£ÌÒ" };

        Diagram bd = new BarDiagram(dataset, fruits);
        bd.setTitle("Öù×´Í¼");
        bd.draw();

        Diagram ld = new LineDiagram(dataset, fruits);
        ld.setTitle("ÕÛÏßÍ¼");
        ld.draw();

        Diagram pd = new PieDiagram(dataset, fruits);
        pd.setTitle("±ýÍ¼");
        pd.setFrameTitle("±êÌâ");
        pd.draw();

        Diagram sd = new SpiderDiagram(dataset, fruits);
        sd.setTitle("ÖëÍøÍ¼");
        sd.draw();
    }

}
