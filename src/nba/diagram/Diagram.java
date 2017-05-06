package nba.diagram;

import org.jfree.chart.JFreeChart;

public abstract class Diagram {
   
    private JFreeChart diagram;
    private String[] axis = new String[]{""};
    private String title = "";
    
    public void setAxis(String[] axis) {
        this.axis = axis;
    }
    
    public String[] getAxis() {
        return axis;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public abstract void draw();
    
    public static void main(String[] args) {
        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "apple", "banana", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        
        Diagram bd = new BarDiagram(dataset, fruits);
        bd.setTitle("Çò¶Ó");
        bd.draw();
        Diagram ld = new LineDiagram(dataset, fruits);
        ld.draw();
        Diagram pd = new PieDiagram(dataset, fruits);
        pd.draw();
    }
}
