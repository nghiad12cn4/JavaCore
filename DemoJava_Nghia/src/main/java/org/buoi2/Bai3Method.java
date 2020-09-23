package org.buoi2;

import java.util.ArrayList;

public class Bai3Method {
    public ArrayList<Integer> listSoNguyenTo(Integer listInteger[]) {
        ArrayList<Integer> actualResult = new ArrayList<>();
        for (int i = 0; i < listInteger.length; i++) {
            if (isPrime(listInteger[i]) == true) {
                actualResult.add(listInteger[i]);
            }
        }
        return actualResult;

    }

    public static boolean isPrime(int n) {
        boolean result = true;
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
