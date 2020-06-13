import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.youtube.com/watch?v=LPFhl65R7ww (BEST VIDEO EXPLANATION)
// https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
// https://practice.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays/0/

public class DivConquer_SumOfMidElementsOfTwoSortedArr {

    // this is leetcode problem solution
    /*public double findMedianSortedArrays(int[] input1, int[] input2) {
        if(input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while(low <= high) {
            int partitionX = low + (high - low)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxOfLeftX  = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minOfRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxOfLeftY  = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minOfRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if(maxOfLeftX <= minOfRightY && maxOfLeftY <= minOfRightX) {
                if((x + y) % 2 == 0) {
                    return ((double) Math.max(maxOfLeftX, maxOfLeftY) + Math.min(minOfRightX, minOfRightY))/2;
                }
                else {
                    return (double) Math.max(maxOfLeftX, maxOfLeftY);
                }
            }
            else if(maxOfLeftX > minOfRightY) {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }
        return -1;
    }*/


    // below solution is a bit small variant of above solution
    private static int findSumOfMedianOfTwoSortedArrays(int[] input1, int[] input2) {

        if(input1.length > input2.length) {
            return findSumOfMedianOfTwoSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while(low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxOfLeftX  = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX-1];
            int minOfRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxOfLeftY  = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY-1];
            int minOfRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if(maxOfLeftX <= minOfRightY && maxOfLeftY <= minOfRightX) {
                if((x + y) % 2 == 0) {
                    return Math.max(maxOfLeftX, maxOfLeftY) + Math.min(minOfRightX, minOfRightY);
                }
                else {
                    return Math.max(maxOfLeftX, maxOfLeftY);
                }
            }
            else if(maxOfLeftX > minOfRightY) {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str1 = br.readLine().trim().split("\\s+");
            String[] str2 = br.readLine().trim().split("\\s+");
            int[] input1 = new int[n];
            int[] input2 = new int[n];

            for(int i = 0; i < n; i++) {
                input1[i] = Integer.parseInt(str1[i]);
                input2[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(findSumOfMedianOfTwoSortedArrays(input1, input2));
        }
    }
}
