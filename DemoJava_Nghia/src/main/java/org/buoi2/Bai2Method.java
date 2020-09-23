package org.buoi2;

public class Bai2Method {
    public boolean checkPrime(int n) {
        int max = n / 2;
        boolean isPrime = true;
        for (int i = 1; i < max; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
