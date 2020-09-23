package org.buoi2;

public class Bai5Method {
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
        boolean result = false;
        while (fibonacci(i) <= value) {
            if (fibonacci(i) > value) {
                result = false;
            }
            if (fibonacci(i) == value) {
                result = true;
                break;
            }
            i++;
        }
        return result;
    }
}
