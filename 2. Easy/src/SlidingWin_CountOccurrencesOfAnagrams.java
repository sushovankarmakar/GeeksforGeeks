import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams/0
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// https://www.youtube.com/watch?v=px9WEf0Lpjc
// https://www.youtube.com/results?search_query=Find+All+Anagrams+in+a+String
// https://www.youtube.com/watch?v=fYgU6Bi2fRg&t=305s

public class SlidingWin_CountOccurrencesOfAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0){
            String ip = br.readLine().trim();
            String pattern = br.readLine().trim();
            System.out.println(countOccurrencesOfAnagrams(ip, pattern).size());
        }
    }

    private static List<Integer> countOccurrencesOfAnagrams(String s, String pattern) {
        if(s == null || pattern == null || s.length() == 0 || s.length() < pattern.length())
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int[] pCharFreq = new int[256];
        int[] sCharFreq = new int[256];

        int sLen = s.length(), pLen = pattern.length();

        for (int i = 0; i < pLen; ++i) {
            pCharFreq[pattern.charAt(i)]++;
            sCharFreq[s.charAt(i)]++;
        }

        for (int i = pLen; i < sLen; ++i) {
            if(Arrays.equals(pCharFreq, sCharFreq)) {
                result.add(i-pLen); // storing the start indices of pattern string anagram
            }

            sCharFreq[s.charAt(i)]++; // adding the current character of current window
            sCharFreq[s.charAt(i-pLen)]--; // removing the first character of previous window
        }

        // Check for the last window in string
        if(Arrays.equals(pCharFreq, sCharFreq)) {
            result.add(sLen - pLen);
        }

        return result;
    }
}
