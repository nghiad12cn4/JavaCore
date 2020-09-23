package org.buoi2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Bai5 {
    Bai5Method bai5Method = new Bai5Method();

    @Test
    public void happyCase() {
        int number = 5;
        boolean expectedResult = true;
        boolean actualResult = bai5Method.checkFibonacci(5);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void exceptionCase() {
        int number = 6;
        boolean expectedResult = false;
        boolean actualResult = bai5Method.checkFibonacci(6);
        Assert.assertFalse(actualResult);
    }


}
