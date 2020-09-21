package org.buoi2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class Bai2 {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        int soNguyenTo = 3;
        assertEquals(true, checkPrime(soNguyenTo));
    }

    public static boolean checkPrime(int n) {
        int max = n / 2;
        for (int i = 1; i < max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
