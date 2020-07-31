import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0
// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/ (Similar problem)
// https://leetcode.com/problems/climbing-stairs/ (Similar problem)
// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
// https://www.youtube.com/watch?v=CFQk7OQO_xM (BEST Video)
// https://www.youtube.com/watch?v=NFJ3m9a1oJQ
// https://www.youtube.com/watch?v=5o-kdjv7FD0

public class DP_CountWaysToReachNthStairUsing12Steps {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int[] fibonacciNumbers = getFibonacciNumbers(); // pre calculation of fibonacci number up to 10^5
        while (t-- > 0) {
            int numOfStairs = Integer.parseInt(br.readLine().trim());

            /*we can pre calculate fibonacci numbers up to 10^5 and then for every query print output in O(1*/
            //System.out.println(fibonacciNumbers[numOfStairs]);

            System.out.println(getNumOfWaysToReachNthStair(numOfStairs + 1));
        }
    }

    /*LOGIC : if the numOfStairs is n, then we need to find out the (n + 1)th fibonacci number*/
    private static int getNumOfWaysToReachNthStair(int numOfStairs) {
        int modulo = 1000000007;
        int lastNumber = 1;
        int secondLastNumber = 1;
        int currentNumber = lastNumber + secondLastNumber;
        if(numOfStairs <= 2) return lastNumber;

        for (int i = 3; i <= numOfStairs; i++) {
            currentNumber = (lastNumber + secondLastNumber) % modulo;
            secondLastNumber = lastNumber;
            lastNumber = currentNumber;
        }
        return currentNumber;
    }

    private static int[] getFibonacciNumbers() {
        int modulo = 1000000007;
        int[] fibonacciNumbers = new int[100001];
        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;

        for(int i = 2; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = (fibonacciNumbers[i-1] + fibonacciNumbers[i-2]) % modulo;
        }
        return fibonacciNumbers;
    }
}
