import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0/
// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0 , Hash_SubArrayWithZeroSum (Similar problem)
// https://ide.geeksforgeeks.org/MgGndmGeRW (a good solution)
// https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/

public class Hash_PrintAllZeroSumSubArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            long[] ip = new long[n];
            for (int i = 0; i < n; i++) {
                ip[i] = Long.parseLong(str[i]);
            }
            System.out.println(getAllZeroSumSubArrays(ip));
            //System.out.println(zeroSumSubArrays.size());
        }
    }

    private static long getAllZeroSumSubArrays(long[] ip) {
        Map<Long, Integer> prefixSumFreqMap = new HashMap<>();  // map stores prefixSum and it's frequency

        int count = 0;
        long prefixSum = 0;
        prefixSumFreqMap.put(0L, 1);    // handling special case for zero.

        for (long value : ip) {
            prefixSum += value;

            count += prefixSumFreqMap.getOrDefault(prefixSum, 0);   // get all the frequency of this prefixSum

            prefixSumFreqMap.put(prefixSum, prefixSumFreqMap.getOrDefault(prefixSum, 0) + 1);   // add this prefixSum to map
        }
        System.out.println(prefixSumFreqMap);
        return count;
    }
}
