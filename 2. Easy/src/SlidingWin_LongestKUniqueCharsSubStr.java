import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring/0
// https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
// https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
// https://www.youtube.com/watch?v=KqXKT-QlCwY&t=3s
// https://www.youtube.com/watch?v=8AQra0p_HmI
// https://leetcode.com/problems/fruit-into-baskets/submissions/ (same problem)

public class SlidingWin_LongestKUniqueCharsSubStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String ip = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(getLongestKUniqueCharsSubString(ip, k));
        }
    }

    private static int getLongestKUniqueCharsSubString(String ip, int k) {
        if(ip == null || ip.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for (end = 0;  end < ip.length(); ++end) {
            char endChar = ip.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            while (map.size() > k) {
                char startChar = ip.charAt(start);

                if(map.get(startChar) > 0) {
                    map.put(startChar, map.get(startChar) - 1);
                }

                if(map.get(startChar) == 0) {
                    map.remove(startChar);  // if count is zero, then it is outside of the window, remove it.
                }

                ++start;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
