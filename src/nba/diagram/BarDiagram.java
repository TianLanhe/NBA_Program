package nba.diagram;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class BarDiagram extends Diagram {
    private static String xAxis = "";
    private static JFreeChart barChart;
    private static DefaultCategoryDataset dataset;
    private static Font font;

    public BarDiagram() {
    }

    // ��ͼǰҪ������� DefaultCategoryDataset ��ֵ
    public BarDiagram(double[] values, String[] keys) {
        if (values.length != keys.length) {
            System.out.println("Error! Length of each paramter is not equal!");
            System.exit(0);
        }

        dataset = new DefaultCategoryDataset();

        for (int i = 0; i < values.length; ++i) {
            dataset.addValue(values[i], xAxis, keys[i]);
        }
    }

    public void draw() {
        
        String title = super.getTitle();
        font = new Font("΢���ź�", Font.BOLD, 14);
        
        barChart = ChartFactory.createBarChart(title, "����", "value", dataset);
        barChart.getTitle().setFont(font);
        
        font = new Font("΢���ź�", Font.ITALIC, 12);
        CategoryPlot cp = barChart.getCategoryPlot();
        CategoryAxis axis = cp.getDomainAxis();
        axis.setLabelFont(font);
        axis.setTickLabelFont(new Font("΢���ź�", Font.ITALIC, 12));
        
        ChartFrame frame = new ChartFrame(title, barChart, true);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "apple", "Ӧ��", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        BarDiagram b = new BarDiagram(dataset, fruits);
        b.setTitle(new String("ͳ��ͼ"));
        b.draw();

    }
}
