import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
// https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0 (Similar problem)
// https://www.youtube.com/watch?v=CFQk7OQO_xM (BEST Video)
// https://www.youtube.com/watch?v=NFJ3m9a1oJQ
// https://www.youtube.com/watch?v=5o-kdjv7FD0

public class DP_CountWaysToReachNthStairUsing123Steps {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int numOfStairs = Integer.parseInt(br.readLine().trim());
            System.out.println(getNumOfWaysToReachNthStair(numOfStairs));
        }
    }

    private static int getNumOfWaysToReachNthStair(int n) {
        if(n == 0 || n == 1 || n == 2) return n;
        if(n == 3) return 4;

        int modulo = 1000000007;
        int thirdLastNumber = 1;
        int secondLastNumber = 2;
        int lastNumber = 4;

        int currentNumber = 0;

        for(int i = 4; i <= n; i++) {
            currentNumber = ( (lastNumber + secondLastNumber)% modulo + thirdLastNumber) % modulo;

            thirdLastNumber = secondLastNumber % modulo;
            secondLastNumber = lastNumber % modulo;
            lastNumber = currentNumber % modulo;
        }
        return currentNumber % modulo;
    }
}
