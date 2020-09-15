import java.util.Scanner;

public class Bai4 {

    public static void main(String[] args) {
        System.out.println("Nhap so phan tu mang so nguyen 1: ");
        int a = new Scanner(System.in).nextInt();
        int A[]= inIt(a);
        System.out.println("Nhap so phan tu mang so nguyen 2: ");
        int b = new Scanner(System.in).nextInt();
        int B[]= inIt(b);
        System.out.println("Tong cua 2 mang la " + (sumArray(A,a)+ sumArray(B,b)));

    }

    public static int[] inIt(int a) {
        int B[];
        B = new int[a];
        for (int i = 0; i < a; i++) {
            B[i] = new Scanner(System.in).nextInt();
        }
        return B;
    }

    public static int sumArray(int A[], int a) {
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum = sum + A[i];
        }
        return sum;
    }
}
