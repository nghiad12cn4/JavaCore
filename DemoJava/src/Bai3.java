import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        System.out.println("Number of list integer");
        int a = new Scanner(System.in).nextInt();
        int B[] = inIt(a);
        System.out.println("List prime: ");
        for (int i = 0; i < a; i++) {
            if (checkPrime(B[i]) == true) {
                System.out.println(B[i]);
            }
        }
    }

    public static int[] inIt(int a) {
        int B[];
        B = new int[a];
        for (int i = 0; i < a; i++) {
            B[i] = new Scanner(System.in).nextInt();
        }
        return B;
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
