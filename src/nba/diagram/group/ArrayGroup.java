package nba.diagram.group;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;

public class ArrayGroup {

    private int memberInGroup;
    private int groupNum;

    public ArrayGroup(int groupNum) {
        if (groupNum <= 0)
            this.groupNum = 1;
        else
            this.groupNum = groupNum;
    }

    public String[] setCategoryGroup(String[] keys) {

        countMemberInGroup(keys);
        if (memberInGroup == 1)
            return keys;

        String[] ret = new String[countGroupArrayLength(keys)];

        groupArray(ret, keys);
        return ret;
    }

    public double[] setValueGroup(double[] values) {

        countMemberInGroup(values);
        if (memberInGroup == 1)
            return values;

        double[] ret = new double[countGroupArrayLength(values)];

        groupArray(ret, values);
        return ret;
    }

    private void countMemberInGroup(String[] keys) {
        if (keys.length % groupNum != 0) {
            memberInGroup = keys.length / groupNum + 1;
        } else {
            memberInGroup = keys.length / groupNum;
        }
    }

    private void countMemberInGroup(double[] values) {
        if (values.length % groupNum != 0) {
            memberInGroup = values.length / groupNum + 1;
        } else {
            memberInGroup = values.length / groupNum;
        }
    }

    private void groupArray(String[] ret, String[] keys) {
        for (int i = 0; i < keys.length; i += memberInGroup) {
            reduceGroup(ret, keys, i);
        }
    }

    private void reduceGroup(String[] ret, String[] keys, int i) {
        if (i + memberInGroup > keys.length) {
            ret[ret.length - 1] = keys[i] + "-" + keys[keys.length - 1];
        } else {
            ret[i / memberInGroup] = keys[i] + "-" + keys[i + memberInGroup - 1];
        }
    }

    private void groupArray(double[] ret, double[] values) {
        for (int i = 0; i < values.length; i += memberInGroup) {
            int sum = addGroupNum(values, i);
            reduceGroup(ret, values, i, sum);
        }
    }

    private void reduceGroup(double[] ret, double[] values, int i, int sum) {
        if (i + memberInGroup > values.length) {
            ret[ret.length - 1] = sum;
        } else {
            ret[i / memberInGroup] = sum;
        }
    }

    private int addGroupNum(double[] values, int groupStart) {
        int sum = 0;
        for (int j = groupStart; j < groupStart + memberInGroup && j < values.length; ++j) {
            sum += values[j];
        }
        return sum;
    }

    private int countGroupArrayLength(String[] keys) {
        int retLength;
        if (keys.length % memberInGroup == 0)
            retLength = keys.length / memberInGroup;
        else
            retLength = keys.length / memberInGroup + 1;

        return retLength;
    }

    private int countGroupArrayLength(double[] values) {
        int retLength;
        if (values.length % memberInGroup == 0)
            retLength = values.length / memberInGroup;
        else
            retLength = values.length / memberInGroup + 1;

        return retLength;
    }

    public static void main(String[] args) {
        String[] a = { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" };
        double[] b = { 70, 80, 99, 5, 24, 18, 22, 33, 55, 100 };

        ArrayGroup gap = new ArrayGroup(3);
        String[] t1 = gap.setCategoryGroup(a);
        double[] t2 = gap.setValueGroup(b);

        for (int i = 0; i < t1.length; ++i) {
            System.out.println(t1[i] + " " + t2[i]);
        }

        double[] values = new double[10];
        String[] keys = new String[10];
        for (int i = 0; i < 10; ++i) {
            values[i] = i;
            keys[i] = Integer.toString(i);
        }
        
        ArrayGroup ag = new ArrayGroup(7);
        
        keys = ag.setCategoryGroup(keys);
        values = ag.setValueGroup(values);
        
        Diagram d = DiagramFactory.createBarDiagram(values, keys);
        d.draw();

    }

}
