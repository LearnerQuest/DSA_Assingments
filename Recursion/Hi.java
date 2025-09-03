package Recursion;

import java.util.Scanner;

public class Hi {
    static int countHi(String str) {
        if (str.length() < 2) return 0;
        if (str.startsWith("hi")) {
            return 1 + countHi(str.substring(2));
        } else {
            return countHi(str.substring(1));
        }
    }

    // (b) Remove all "hi"
    static String removeHi(String str) {
        if (str.length() < 2) return str;
        if (str.startsWith("hi")) {
            return removeHi(str.substring(2));
        } else {
            return str.charAt(0) + removeHi(str.substring(1));
        }
    }

    // (c) Replace "hi" with "bye"
    static String replaceHi(String str) {
        if (str.length() < 2) return str;
        if (str.startsWith("hi")) {
            return "bye" + replaceHi(str.substring(2));
        } else {
            return str.charAt(0) + replaceHi(str.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(countHi(str));
        System.out.println(removeHi(str));
        System.out.println(replaceHi(str));
    }
}
