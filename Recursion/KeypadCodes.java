package Recursion;

public class KeypadCodes {
    public static void main(String[] args) {
        String s = "12";
        printKeypadCodes(s, "", 0);
    }
    static String getLetters(char digit) {
        return switch (digit) {
            case '1' -> "abc";
            case '2' -> "def";
            case '3' -> "ghi";
            case '4' -> "jkl";
            case '5' -> "mno";
            case '6' -> "pqrs";
            case '7' -> "tuv";
            case '8' -> "wxyz";
            default -> "";
        };
    }
    public static void printKeypadCodes(String s, String current, int index) {
        // Base case: if we've processed all digits
        if (index == s.length()) {
            System.out.print(current + " ");
            return;
        }

        // Get the current digit and its corresponding letters
        char digit = s.charAt(index);
        String letters = getLetters(digit);

        // Recur for each letter corresponding to the current digit
        for (int i = 0; i < letters.length(); i++) {
            printKeypadCodes(s, current + letters.charAt(i), index + 1);
        }

    }
    

}
