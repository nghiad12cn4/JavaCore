package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void stringFilterHappyCase() {
        String result = "Nguyen Thi Huong";
        XuLyChuoi xuLyChuoi = new XuLyChuoi();
        String actualResult = xuLyChuoi.xuLyChuoi("nguyen Thi HUONG");
        String expectedResult = "Nguyen Thi Huong";
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void stringFilterExceptionCase() {
        String result = " ";
        XuLyChuoi xuLyChuoi = new XuLyChuoi();
        String actualResult = xuLyChuoi.xuLyChuoi("");
        String expectedResult = null;
        assertEquals(actualResult, expectedResult);
    }
}
