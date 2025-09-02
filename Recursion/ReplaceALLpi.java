package Recursion;

public class ReplaceALLpi {
    public static void main(String[] args) {
        String s = "xpixy";
        String result = replacePi(s);
        System.out.println(result);
    }
    static String replacePi(String s) {
        if (s.length() < 2) return s; // Base case: if string is too short, return it as is
        if (s.startsWith("pi")) {
            // Replace "pi" with "3.14" and recurse on the rest of the string
            return "3.14" + replacePi(s.substring(2));
        } else {
            // Keep the first character and recurse on the rest of the string
            return s.charAt(0) + replacePi(s.substring(1));
        }
    }
}
