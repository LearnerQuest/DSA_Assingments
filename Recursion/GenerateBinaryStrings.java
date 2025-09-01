package Recursion;

public class GenerateBinaryStrings {
    public static void main(String[] args) {
    //10000101 10001101 10100101 10101101 11000101 11001101 11100101 11101101
        String s = "1?0?01";
        char[] str = s.toCharArray();
        generate(str, 0);
    }
    public static void generate(char[] str, int index) {
        // base case: reached end of string
        if (index == str.length) {
            System.out.print(new String(str) + " ");
            return;
        }
        // if current char is '?'
        if (str[index] == '?') {
            // replace with '0' and recurse
            str[index] = '0';
            generate(str, index + 1);

            // replace with '1' and recurse
            str[index] = '1';
            generate(str, index + 1);

            // backtrack: restore '?'
            str[index] = '?';
        } else {
            // if char is '0' or '1', just move ahead
            generate(str, index + 1);
        }
    }
}
