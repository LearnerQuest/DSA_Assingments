package  Recursion;
import java.util.*;
public class HiProblem {

    // (a) Count "hi" not followed by 't'
    public static int countHi(String str) {
        if (str.length() < 2) return 0;

        if (str.startsWith("hi")) {
            if (str.length() > 2 && str.charAt(2) == 't') {
                return countHi(str.substring(1)); // skip only 'h'
            } else {
                return 1 + countHi(str.substring(2)); // count this "hi"
            }
        }
        return countHi(str.substring(1)); // move ahead
    }

    // (b) Remove "hi" not followed by 't'
    public static String removeHi(String str) {
        if (str.length() < 2) return str;

        if (str.startsWith("hi")) {
            if (str.length() > 2 && str.charAt(2) == 't') {
                return "h" + removeHi(str.substring(1)); // keep 'h'
            } else {
                return removeHi(str.substring(2)); // remove "hi"
            }
        }
        return str.charAt(0) + removeHi(str.substring(1));
    }

    // (c) Replace "hi" with "bye" not followed by 't'
    public static String replaceHi(String str) {
        if (str.length() < 2) return str;

        if (str.startsWith("hi")) {
            if (str.length() > 2 && str.charAt(2) == 't') {
                return "h" + replaceHi(str.substring(1)); // keep 'h'
            } else {
                return "bye" + replaceHi(str.substring(2)); // replace
            }
        }
        return str.charAt(0) + replaceHi(str.substring(1));
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(countHi(input));
        System.out.println(removeHi(input));
        System.out.println(replaceHi(input));

        sc.close();
    }
}
