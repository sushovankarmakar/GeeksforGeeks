import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
// https://leetcode.com/problems/generate-parentheses/
// https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
// https://www.youtube.com/watch?v=I9GxNZBLYdk&t=128s (great recursion tree visualization and explanation)
// https://www.youtube.com/results?search_query=Generate+balanced+bracket+combinations

public class Backtracking_GenerateAllPossibleParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<String> output = allParenthesis(n);
            StringBuilder sb = new StringBuilder();
            for (String str : output) {
                sb.append(str + "\n");
            }
            System.out.print(sb);
            sb.setLength(0);
        }
    }

    public static List<String> allParenthesis(int n)
    {
        List<String> output = new ArrayList<>();
        backtracking(output, "", 0, 0, n);
        return output;
    }

    private static void backtracking(List<String> output, String currStr, int open, int close, int max) {
        if(currStr.length() == max*2) {
            output.add(currStr);
            return;
        }

        if(open < max) {
            backtracking(output, currStr + "(", open + 1, close, max);
        }

        if(close < open) {
            backtracking(output, currStr + ")", open, close + 1, max);
        }
    }
}
