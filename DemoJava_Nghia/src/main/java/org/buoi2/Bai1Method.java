package org.buoi2;

public class Bai1Method {
    public static int countForNumber(int listInteger[], int n) {
        int count = 0;
        for (int i = 0; i < listInteger.length; i++) {
            if (listInteger[i] == n) {
                count++;
            }
        }
        return count;
    }
}

