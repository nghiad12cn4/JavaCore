package org.buoi2;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class Bai2 {
    /**
     * Rigorous Test :-)
     */
    Bai2Method bai2Method = new Bai2Method();

    @Test
    public void happyCase() {
        int soNguyenTo = 3;
        boolean actualResult = bai2Method.checkPrime(soNguyenTo);
        assertTrue(actualResult);
    }

    @Test
    public void exceptionCase() {
        int soNguyenTo = 4;
        boolean actualResult = bai2Method.checkPrime(soNguyenTo);
        assertFalse(actualResult);
    }


}
