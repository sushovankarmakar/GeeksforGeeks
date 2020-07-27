import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0
// https://www.youtube.com/watch?v=y2BD4MJqV20 (BEST Video Explanation)
// https://leetcode.com/problems/longest-palindromic-substring/solution/
// https://leetcode.com/problems/longest-palindromic-substring/
// https://www.youtube.com/watch?v=OwjIfAy1OqA
// https://www.youtube.com/watch?v=DK5OKKbF6GI

public class Strings_LongestPalindromeSubString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine().trim();
            //System.out.println(getLongestPalindromeSubString_1(str));
            System.out.println(getLongestPalindromeSubString_2(str));
        }
    }

    // APPROACH - 1 : time complexity : O(n^2), space complexity : O(1)
    private static String getLongestPalindromeSubString_1(String str) { // time complexity : O(n^2)
        if(str == null || str.length() < 1) return "";

        String palindromicString = str.substring(0,1);

        for(int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String currentString = str.substring(i, j + 1);   // j+1 cause second parameter is excluded. example : aaaabbaa
                if(isPalindrome(currentString)) {
                    palindromicString =
                            (currentString.length() > palindromicString.length()) ? currentString : palindromicString;
                }
            }
        }
        return palindromicString;
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // APPROACH - 2 : (https://www.youtube.com/watch?v=y2BD4MJqV20) (has more readability than approach 3)
    // time complexity : O(n^2), space complexity : O(1)

    private static String getLongestPalindromeSubString_2(String str) {

        if(str == null || str.length() < 1) return "";

        String maxLengthPalindromicString = "";

        for(int i = 0; i < str.length(); i++) {
            String string1 = expandAroundCentre(str, i, i);            // racecar - odd length palindrome
            String string2 = expandAroundCentre(str, i, i+1);    // aabbaa - even length palindrome

            String currentPalindromicString = string1.length() > string2.length() ? string1 : string2;

            /*if two palindromic substring has same length, then we need to return the first one
            for that we need to keep tract of the below comparision.
            example : ayaxzfbjbkrxiri has two palindrome. aya, iri. we need to return aya*/

            maxLengthPalindromicString = currentPalindromicString.length() > maxLengthPalindromicString.length() ?
                    currentPalindromicString : maxLengthPalindromicString;
        }

        return maxLengthPalindromicString;
    }

    private static String expandAroundCentre(String str, int left, int right) {

        // starts from centre. expand both side and check left char and right char is same or not
        while(0 <= left && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        // value of left can be -1, so left + 1. value of right is exclusive
        return str.substring(left + 1, right);
    }


    // APPROACH - 3 : exactly same as approach 2, but approach 2 is has more readability, or else logic is same
    // time complexity : O(n^2), space complexity : O(1)

    private static String getLongestPalindromeSubString_3(String str) {

        if(str == null || str.length() < 1) return "";

        int start = 0;
        int end = 0;

        String maxLengthPalindromicString = "";

        for(int i = 0; i < str.length(); i++) {
            int length1 = expandAroundCentre3(str, i, i);            // racecar - odd length palindrome
            int length2 = expandAroundCentre3(str, i, i+1);    // aabbaa - even length palindrome
            int length = Math.max(length1, length2);

            if(length > (end - start)) {
                start = i - ((length - 1) / 2);     // be careful in this calculation
                end = i + (length / 2);
            }

            String currentPalindromicString = str.substring(start, end + 1); // end + 1 cause second parameter is excluded.

            /*if two palindromic substring has same length, then we need to return the first one
            for that we need to keep tract of the below comparision*/

            maxLengthPalindromicString = currentPalindromicString.length() > maxLengthPalindromicString.length() ?
                    currentPalindromicString : maxLengthPalindromicString;
        }

        return maxLengthPalindromicString;
    }

    private static int expandAroundCentre3(String str, int left, int right) {

        while(0 <= left && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;    // be careful here, or array out of bound exception
    }
}
