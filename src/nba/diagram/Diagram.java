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
    private String frameTitle = "ͳ��ͼ";
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
        mChartTheme.setExtraLargeFont(new Font("΢���ź�", Font.BOLD, 20));       // ���ñ�������
        mChartTheme.setLargeFont(new Font("΢���ź�", Font.CENTER_BASELINE, 12)); // ������������
        mChartTheme.setRegularFont(new Font("΢���ź�", Font.PLAIN, 12));         // ����ͼ������
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
        String[] fruits = { "ƻ��", "�㽶", "����", "����", "����", "����", "ӣ��" };

        Diagram bd = new BarDiagram(dataset, fruits);
        bd.setTitle("��״ͼ");
        bd.draw();

        Diagram ld = new LineDiagram(dataset, fruits);
        ld.setTitle("����ͼ");
        ld.draw();

        Diagram pd = new PieDiagram(dataset, fruits);
        pd.setTitle("��ͼ");
        pd.setFrameTitle("����");
        pd.draw();

        Diagram sd = new SpiderDiagram(dataset, fruits);
        sd.setTitle("����ͼ");
        sd.draw();
    }

}
