package org.buoi2;

public class Bai4Method {
    public int[] sumArray(int arr1[], int arr2[]) {
        int maxList = this.arrayMaxLeng(arr1, arr2);
        int[] sumArr = new int[maxList];
        for (int i = 0; i < maxList; i++) {
            if (arr1.length > i && arr2.length > i) {
                sumArr[i] = arr1[i] + arr2[i];
            } else if (arr1.length > i && arr2.length <= i) {
                sumArr[i] = arr1[i];
            } else {
                sumArr[i] = arr2[i];
            }
        }
        return sumArr;
    }


    public int arrayMaxLeng(int A[], int B[]) {
        if (A.length > B.length) {
            return A.length;
        }
        return B.length;
    }
}
