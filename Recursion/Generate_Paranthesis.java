package Recursion;
import java.util.*;

public class Generate_Paranthesis {
    static void generate(int open, int close, String path, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(path);
            return;
        }

        // Try to add '('
        if (open > 0) {
            generate(open - 1, close, path + "(", result);
        }

        // Try to add ')'
        if (close > open) {
            generate(open, close - 1, path + ")", result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> result = new ArrayList<>();
        generate(n, n, "", result);

        // Ensure lexicographically sorted
        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}

