import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k/0
// https://www.geeksforgeeks.org/count-pairs-difference-equal-k/

public class Hash_CountDistinctPairsWithDiffK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int k = Integer.parseInt(br.readLine().trim());
            int[] ip = new int[n];
            for(int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            System.out.println(countDistinctPairsWithDiffK(ip, k));
        }
    }

    private static int countDistinctPairsWithDiffK(int[] ip, int k) {
        Map<Integer, Integer> map = getMap(ip);
        return getCount(map, k);
    }

    private static Map<Integer, Integer> getMap(int[] ip) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : ip) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return map;
    }

    private static int getCount(Map<Integer, Integer> map, int k) {
        int count = 0;

        if(k == 0) { // if k is zero, check which values frequency is more than 2
            for(int value : map.values()) {
                if(value >= 2) count++;
            }
        }
        else {
            for(int num : map.keySet()) {
                if(map.containsKey(num + k)) count++;
            }
        }
        return count;
    }
}
