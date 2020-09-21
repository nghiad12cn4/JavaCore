package org.buoi2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Bai4 {
    @Test
    public void shouldAnswerWithTrue() {
        int mang1[] = {1, 2, 3, 4};
        int mang2[] = {1, 2, 3};
        int tongMang = 16;
        Assert.assertEquals(tongMang,sumArray(mang1) + sumArray(mang2));
    }

    public static int sumArray(int A[]) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        return sum;
    }
}
