import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=4ykBXGbonlA (best video explanation)
// https://leetcode.com/problems/palindrome-partitioning/
// https://leetcode.com/problems/palindrome-partitioning-ii/ (Similar Question)
// https://www.youtube.com/watch?v=A0wENqSIxK4
// https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution.
// https://www.youtube.com/results?search_query=Partition+string+into+palindromes
// https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
// https://www.geeksforgeeks.org/print-palindromic-partitions-string/
// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/PalindromePartition.java
// https://practice.geeksforgeeks.org/problems/palindromic-patitioning/0 (Similar Question)

// time complexity : O(n * (2^n))
// space complexity : O(n)  (call stack)

/*
* input : nitin
* output : [ {n, i, t, i, n}, {n, iti, n}, {nitin} ]
* */

public class Backtracking_PalindromePartitioning {

    private static List<List<String>> partition(String s) {
        List<List<String>> decompositions = new ArrayList<>();
        decomposeString(s, 0, new ArrayList<>(), decompositions);
        return decompositions;
    }

    private static void decomposeString(String s, int startIndex, List<String> partialDecomposition,
                                        List<List<String>> decompositions) {

        if(startIndex == s.length()) {    // If we have decomposed the whole string then return
            decompositions.add(new ArrayList<>(partialDecomposition));
            return;
        }

        for(int endIndex = startIndex;  endIndex < s.length();  endIndex++) {
            String subString = s.substring(startIndex, endIndex+1);

            // Only recurse if the substring is a palindrome
            if(isPalindrome(subString)) {

                // 1.) Choose - Take the subString & add it to our decomposition 'path'
                partialDecomposition.add(subString);

                // 2.) Explore - Recurse and advance progress 1 past right bound of the 'palindromicSnippet' which is 'i + 1'
                decomposeString(s, endIndex + 1, partialDecomposition, decompositions);

                // 3.) Unchoose - We are done searching, remove the snippet from our 'path'. Next loop iteration will try another snippet in this stack frame.
                partialDecomposition.remove(partialDecomposition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String s = br.readLine().trim();
            List<List<String>> output = partition(s);

            for (List<String> list : output) {
                System.out.print(list + " ");
            }
            System.out.println();
        }
    }
}
