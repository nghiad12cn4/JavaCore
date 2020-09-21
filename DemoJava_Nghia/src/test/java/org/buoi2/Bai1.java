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
    @Test
    public void shouldAnswerWithTrue() {
        int Mang[] = {1, 2, 3, 4, 4, 3, 3, 2, 1};
        int soLanXuatHienSo3 = 3;
        assertEquals(soLanXuatHienSo3, countForNumber(Mang, 3));
    }


    public static int countForNumber(int B[], int n) {
        int count = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == n) {
                count++;
            }
        }
        return count;
    }
}
