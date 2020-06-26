import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/anagram-palindrome/0
// https://www.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
// https://www.youtube.com/watch?v=Pp5hdsNdqOU (A very good explanation)
// https://leetcode.com/articles/palindrome-permutation/

public class Hash_AnagramPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String ip = br.readLine().trim();
            System.out.println(canBePalindrome(ip) ? "Yes" : "No");
        }
    }

    private static boolean canBePalindrome(String str) {
        if(str == null) return true;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // while iterating if we find second odd value, then that string
        // can not be palindrome, so return false.

        boolean secondOddValue = false;
        for(int val : map.values()) {
            if(val % 2 != 0) {

                if(!secondOddValue) secondOddValue = true;
                else return false;
            }
        }
        return true;
    }
}
