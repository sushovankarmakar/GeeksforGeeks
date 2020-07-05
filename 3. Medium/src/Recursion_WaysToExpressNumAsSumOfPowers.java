import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 05.07.2020
// https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers/0
// https://www.geeksforgeeks.org/count-ways-express-number-sum-powers/ (very elegant solution)
// https://www.hackerrank.com/challenges/the-power-sum/editorial

// this took a lot time to understand the recursive call stack and the algorithm flow.

public class Recursion_WaysToExpressNumAsSumOfPowers {
    private static int countWays(int x, int n) {
        return countWaysUtil(x, n, 1);
    }

    private static int countWaysUtil(int x, int n, int num) {
        int val = (int) (x - Math.pow(num, n));

        if(val == 0) return 1;
        if(val <  0) return 0;

        // Consider two possibilities, num is included and num is not included.
        return  countWaysUtil(val, n, num + 1) +
                countWaysUtil(x, n, num + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] xn = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(xn[0]);
            int n = Integer.parseInt(xn[1]);
            System.out.println(countWays(x, n));
        }
    }
}
