package Recursion;

import java.util.Scanner;

public class Replace0with5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(convert(N));
    }
    static int convert(int n) {
        int result = 0, place = 1;

        // Handle 0 case directly
        if (n == 0) return 5;

        while (n > 0) {
            int digit = n % 10;
            if (digit == 0) digit = 5;

            result = digit * place + result;
            place *= 10;
            n /= 10;
        }
        return result;
    }
}
