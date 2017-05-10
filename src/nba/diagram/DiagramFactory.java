package nba.diagram;

public class DiagramFactory {
    
    public static BarDiagram createBarDiagram(double[] values, String[] keys) {
        return new BarDiagram(values, keys);
    }
    
    public static LineDiagram createLineDiagram(double[] values, String[] keys) {
        return new LineDiagram(values, keys);
    }
    
    public static PieDiagram createPieDiagram(double[] values, String[] keys) {
        return new PieDiagram(values, keys);  
    }
    
    public static SpiderDiagram createSpiderDiagram(double[] values, String[] keys) {
        return new SpiderDiagram(values, keys);     
    }
    
    public static void main(String[] args) {
        double[] dataset = { 12, 3, 5, 7, 9, 4, 2 };
        String[] fruits = { "apple", "banana", "lemon", "strawberry", "watermelon", "peer", "cherry" };
        BarDiagram bd = DiagramFactory.createBarDiagram(dataset, fruits);
        bd.draw();
        LineDiagram ld = DiagramFactory.createLineDiagram(dataset, fruits);
        ld.draw();
        PieDiagram pd = DiagramFactory.createPieDiagram(dataset, fruits);
        pd.draw();
    }
}
