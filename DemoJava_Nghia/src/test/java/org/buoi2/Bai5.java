package org.buoi2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Bai5 {
    @Test
    public void shouldAnswerWithTrue() {
        int so = 5;
        boolean ketQuaMongMuon = true;
        Assert.assertEquals(ketQuaMongMuon, checkFibonacci(5));
    }


    public static int fibonacci(int value) {
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int fibo = 0;
        if (value < 0) {
            return -1;
        }
        if (value < 2) {
            return 1;
        }
        int i = 2;
        while (i < value) {
            fibo = fibonacci1 + fibonacci2;
            fibonacci1 = fibonacci2;
            fibonacci2 = fibo;
            i++;
        }
        return fibo;
    }

    public static boolean checkFibonacci(int value) {

        int i = 0;
        while (fibonacci(i) <= value) {
            if (fibonacci(i) > value) {
                return false;
            }
            if (fibonacci(i) == value) {
                return true;
            }
            i++;
        }
        return false;
    }
}
