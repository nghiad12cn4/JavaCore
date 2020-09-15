import java.util.Scanner;

public class Bai5 {
    public static boolean checkFibonacci(int value) {

        int i = 0;
        while (fibonacci(i)  <= value) {
            if (fibonacci(i) > value) {
                return false;
            }
            if(fibonacci(i)==value){
                return true;
            }
            i++;
        }
        return false;
    }

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

    public static void main(String[] args) {
        System.out.println("Nhap so: ");
        int n = new Scanner(System.in).nextInt();
        if(checkFibonacci(n)==true){
            System.out.println("Day la so Fibonacci");
        }
        else{
            System.out.println("Day khong la so Fibonacci");
        }

    }
}