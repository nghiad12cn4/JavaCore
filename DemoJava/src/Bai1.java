import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        System.out.println("Nhap so phan tu mang so nguyen: ");
        int a = new Scanner(System.in).nextInt();
        int B[]= inIt(a);
        System.out.println("Nhap so nguyen");
        int n = new Scanner(System.in).nextInt();
        System.out.println("So phan tu co gia tri " + n + " Xuat hien trong day la " + countForNumber(B,a,n));
    }

    public static int[] inIt(int a) {
        int B[];
        B = new int[a];
        for (int i = 0; i < a; i++) {
            B[i] = new Scanner(System.in).nextInt();
        }
        return B;
    }
    public static int countForNumber(int B[], int a, int n) {
        int count = 0;
        for (int i = 0; i < a; i++) {
            if (B[i] == n) {
                count++;
            }
        }
        return count;
    }


}
