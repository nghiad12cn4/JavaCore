package org.buoi2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class Bai1 {
    /**
     * Rigorous Test :-)
     */
    Bai1Method bai1Method = new Bai1Method();

    @Test
    public void happyCase() {
        int listInteger[] = {1, 2, 3, 4, 4, 3, 3, 2, 1};
        int expectedResult = 3;
        int actualResult = bai1Method.countForNumber(listInteger, 3);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void exceptionCase() {
        int Mang[] = {4, 6, 8, 10, 12, 14, 15};
        int expectedResult = 0;
        int actualResult = bai1Method.countForNumber(Mang, 3);
        assertEquals(actualResult, expectedResult);
    }
}
