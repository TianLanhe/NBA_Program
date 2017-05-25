package nba.diagram;

import nba.util.ArrayGroup;

public class DiagramFactory {
    static ArrayGroup arrayGroup;
    
    public static Diagram createDiagram(String chartName, double[] values, String[] keys, int start, int memberNum) {
        arrayGroup = new ArrayGroup(keys, values, start, memberNum);
        
        double[] groupValues = arrayGroup.getValueGroup();
        String[] groupKeys = arrayGroup.getCategoryGroup();
        
        if (chartName.equals("bar")) {
            return new BarDiagram(groupValues, groupKeys);
        } else if (chartName.equals("line")) {
            return new LineDiagram(groupValues, groupKeys);
        } else if (chartName.equals("pie")) {
            return new PieDiagram(groupValues, groupKeys);  
        } else if (chartName.equals("spider")) {
            return new SpiderDiagram(groupValues, groupKeys);     
        } else {
            return null;
        }
        
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
        String[] fruits = { "1991", "1993", "1995", "1997", "1999", "2001", "2003" };
        Diagram bd = DiagramFactory.createDiagram("bar", dataset, fruits, 1990, 2);
        bd.draw();
//        LineDiagram ld = DiagramFactory.createDiagram(dataset, fruits);
//        ld.draw();
//        PieDiagram pd = DiagramFactory.createDiagram(dataset, fruits);
//        pd.draw();
    }
}
