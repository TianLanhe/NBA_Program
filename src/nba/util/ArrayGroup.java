package nba.util;

import java.util.Arrays;

public class ArrayGroup {

    private int start;
    private int[] memberInGroup;   // 按照间隔分组，每组所包括的 keys[i] 数量
    private int distance;
    private int[] keys;
    private double[] values;

    public ArrayGroup(String[] keys, double[] values, int start, int distance) {

        if (start <= Integer.parseInt(keys[0])) {
            this.keys = new int[keys.length];
            for (int i = 0; i < keys.length; ++i) {
                this.keys[i] = Integer.parseInt(keys[i]);
            }
            this.values = values;

        } else {  // 开始值在 keys 最小值 keys[0] 右边 
            int pos = 0;
            while (Integer.parseInt(keys[pos]) < start) {
                ++pos;
            }
            
            String[] temp = Arrays.copyOfRange(keys, pos, keys.length);
            this.keys = new int[temp.length];
            for (int i = 0; i < temp.length; ++i) {
                this.keys[i] = Integer.parseInt(temp[i]);
            }
            this.values = Arrays.copyOfRange(values, pos, values.length);

        }
        this.start = start;
        this.distance = distance;

    }

    public String[] getCategoryGroup() {
        String[] ret;
        if (distance <= 1) {
            ret = new String[keys.length]; 
            for (int i = 0; i < keys.length; ++i)
                ret[i] = Integer.toString(keys[i]);
            return ret;
        }
        
        int len = countGroupArrayLength();
        ret = new String[len];

        groupKeys(ret);
        return ret;
    }

    public double[] getValueGroup() {
        if (distance <= 1) {
            return values;
        }
        
        int len = countGroupArrayLength();
        double[] ret = new double[len];
        
        groupValues(ret);
        return ret;
    }

    private void groupKeys(String[] ret) {

        for (int i = 0, j = start; i < ret.length; ++i, j += distance) {
            ret[i] = Integer.toString(j) + "-" + Integer.toString(j + distance - 1);
        }
    }

    private void initMemberInGroup(double[] ret) {
        memberInGroup = new int[ret.length];

        int k = 0;
        int m = 0;
        for (int i = start; i < start + ret.length * distance; i += distance) {
            int count = 0;
            for (int j = 0; j < distance && m < keys.length && keys[m] < i + distance; ++j) {
                ++count;
                ++m;
            }
            memberInGroup[k] = count;
            ++k;
        }
    }

    private void groupValues(double[] ret) {
        initMemberInGroup(ret);

        int temp = 0;
        for (int i = 0; i < memberInGroup.length; ++i) {
            if (memberInGroup[i] == 0) {
                ret[i] = 0;
            } else {
                for (int j = temp; j < temp + memberInGroup[i]; ++j)
                    ret[i] += values[j];
                temp += memberInGroup[i];
            }
        }
    }

    private int countGroupArrayLength() {

        int retLength;
        int max = keys[keys.length - 1];

        if ((max - start + 1) % distance == 0)
            retLength = (max - start + 1) / distance;
        else
            retLength = (max - start + 1) / distance + 1;

        return retLength;
    }

}
