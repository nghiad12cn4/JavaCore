package org.buoi2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Bai4 {
    Bai4Method bai4Method = new Bai4Method();

    @Test
    public void happyCase() {
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {1, 2, 3};
        int expectedResult[] = {2, 4, 6, 4};
        int actualResult[] = bai4Method.sumArray(arr1, arr2);
        for (int i = 0; i < actualResult.length; i++) {
            System.out.println(actualResult[i]);
        }
        Assert.assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    public void exceptionCase() {
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {1, 2, 3, 4};
        int expectedResult[] = {2, 4, 6, 8};
        int actualResult[] = bai4Method.sumArray(arr1, arr2);
        for (int i = 0; i < actualResult.length; i++) {
            System.out.println(actualResult[i]);
        }
        Assert.assertArrayEquals(actualResult, expectedResult);
    }


}
