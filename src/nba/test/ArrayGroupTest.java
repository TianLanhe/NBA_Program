package nba.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nba.diagram.group.ArrayGroup;

public class ArrayGroupTest {

    private String[] keys;
    private double[] values;

    public void assertDoubleArrayEquals(double[] a, double[] b) {
        for (int i = 0; i < a.length; ++i) {
            assertEquals(a[i], b[i], 0);
        }
    }

    @Before
    public void setUp() {
        keys = new String[] { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" };
        values = new double[] { 70, 80, 99, 5, 24, 18, 22, 33, 55, 100 };
    }

    @Test
    public void testElevenGroup() {
        String[] groupEleven = { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" };
        double[] group11 = { 70, 80, 99, 5, 24, 18, 22, 33, 55, 100 };
        ArrayGroup group = new ArrayGroup(11);
        assertArrayEquals(groupEleven, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group11, group.setValueGroup(values));
    }

    @Test
    public void testTenGroup() {
        String[] groupTen = { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" };
        double[] group10 = { 70, 80, 99, 5, 24, 18, 22, 33, 55, 100 };
        ArrayGroup group = new ArrayGroup(10);
        assertArrayEquals(groupTen, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group10, group.setValueGroup(values));
    }

    @Test
    public void testSevenGroup() {
        String[] groupSeven = { "1991-1992", "1993-1994", "1995-1996", "1997-1998", "1999-2000" };
        double[] group7 = { 150, 104, 42, 55, 155 };
        ArrayGroup group = new ArrayGroup(7);
        assertArrayEquals(groupSeven, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group7, group.setValueGroup(values));
    }

    @Test
    public void testSixGroup() {
        String[] groupSix = { "1991-1992", "1993-1994", "1995-1996", "1997-1998", "1999-2000" };
        double[] group6 = { 150, 104, 42, 55, 155 };
        ArrayGroup group = new ArrayGroup(6);
        assertArrayEquals(groupSix, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group6, group.setValueGroup(values));
    }

    @Test
    public void testFiveGroup() {
        String[] groupFive = { "1991-1992", "1993-1994", "1995-1996", "1997-1998", "1999-2000" };
        double[] group5 = { 150, 104, 42, 55, 155 };
        ArrayGroup group = new ArrayGroup(5);
        assertArrayEquals(groupFive, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group5, group.setValueGroup(values));
    }

    @Test
    public void testFourGroup() {
        String[] groupFour = { "1991-1993", "1994-1996", "1997-1999", "2000-2000" };
        double[] group4 = { 249, 47, 110, 100 };
        ArrayGroup group = new ArrayGroup(4);
        assertArrayEquals(groupFour, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group4, group.setValueGroup(values));
    }

    @Test
    public void testThreeGroup() {
        String[] groupThree = { "1991-1994", "1995-1998", "1999-2000" };
        double[] group3 = { 254, 97, 155 };
        ArrayGroup group = new ArrayGroup(3);
        assertArrayEquals(groupThree, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group3, group.setValueGroup(values));
    }

    @Test
    public void testTwoGroup() {
        String[] groupTwo = { "1991-1995", "1996-2000" };
        double[] group2 = { 278, 228 };
        ArrayGroup group = new ArrayGroup(2);
        assertArrayEquals(groupTwo, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group2, group.setValueGroup(values));
    }

    @Test
    public void testOneGroup() {
        String[] groupOne = { "1991-2000" };
        double[] group1 = { 506 };
        ArrayGroup group = new ArrayGroup(1);
        assertArrayEquals(groupOne, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group1, group.setValueGroup(values));
    }
    
    @Test
    public void testZeroGroup() {
        String[] groupZero = { "1991-2000" };
        double[] group0 = { 506 };
        ArrayGroup group = new ArrayGroup(0);
        assertArrayEquals(groupZero, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group0, group.setValueGroup(values));
    }
    
    @Test
    public void testMinusNumGroup() {
        String[] groupZero = { "1991-2000" };
        double[] group0 = { 506 };
        ArrayGroup group = new ArrayGroup(-1);
        assertArrayEquals(groupZero, group.setCategoryGroup(keys));
        assertDoubleArrayEquals(group0, group.setValueGroup(values));
    }
}
