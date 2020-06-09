import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
// https://practice.geeksforgeeks.org/problems/length-unsorted-subarray/0
// https://www.youtube.com/watch?v=UfBfr-VRYOU&feature=emb_logo
// https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

public class Array_LengthUnsortedSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[] ip = new int[n];
            for(int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            getMinLengthOfUnsortedSubArray(ip);
        }
    }

    /*It's not difficult to understand that the max value of the subArray need to be smaller than the min of the rightmost sorted subArray,
     and the min value of the subArray need to be larger than the max of the leftmost sorted subArray.
     Therefore we care about the max value counted from the left (and the min value counted from the right).
     The other important fact is that whenever we come across a value A[i] that is smaller than the current max,
     we know that the unsorted subArray AT LEAST needs to end here. Similarly, whenever we come across a value A[n-1-i]
     that is larger than the current min, we know that the unsorted subArray AT LEAST needs to start here.*/

    private static void getMinLengthOfUnsortedSubArray(int[] ip) {
        if(ip == null) return;
        int n = ip.length;

        int end = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, ip[i]);
            if(max > ip[i]) {
                end = i;
            }
        }

        int begin = 0;
        int min = Integer.MAX_VALUE;
        for(int i = n-1; i >=0 ; --i) {
            min = Math.min(min, ip[i]);
            if(min < ip[i]) {
                begin = i;
            }
        }

        System.out.println(begin + " " + end);
    }

    /*private static void getMinLengthOfUnsortedSubArray(int[] ip) {
        if(ip == null) return;
        int n = ip.length;
        int left = 0;

        while(left < n-1) {
            if(ip[left] > ip[left + 1]) {
                break;
            }
            ++left;
        }

        if(left == n-1) {
            System.out.println(0 + " " + 0);
            return;
        }

        int right = n-1;

        while(0 < right) {
            if(ip[right-1] > ip[right]) {
                break;
            }
            --right;
        }

        int max = ip[left], min = ip[right];

        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, ip[i]);
            min = Math.min(min, ip[i]);
        }

        for (int i = 0; i < left; i++) {
            if(ip[i] > min) {
                left = i;
                break;
            }
        }

        for (int i = n-1; i >= right + 1; --i) {
            if(ip[i] < max) {
                right = i;
                break;
            }
        }

        System.out.println(left + " " + right);
    }*/

    // using sorting and extra space
    /*private static void getMinLengthOfUnsortedSubArray(int[] originalArr) {

        int[] copiedArr = originalArr.clone();
        Arrays.sort(copiedArr);
        int start = copiedArr.length, end = 0;
        for (int i = 0; i < copiedArr.length; i++) {
            if (copiedArr[i] != originalArr[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        if(end - start >= 0) {
            System.out.println(start + " " + end);
        }
        else {
            System.out.println(0 + " " + 0);
        }
    }*/
}
