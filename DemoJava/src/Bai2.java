import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.println("Input integer: ");
        int n = new Scanner(System.in).nextInt();
        if (checkPrime(n) == false) {
            System.out.println("Not prime");
        } else {
            System.out.println("Prime");
        }
    }

    public static boolean checkPrime(int n) {
        int max = n / 2;
        for (int i = 1; i < max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
