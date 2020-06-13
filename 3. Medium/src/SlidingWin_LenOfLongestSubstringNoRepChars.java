import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://ide.geeksforgeeks.org/v6QnWgI9xH
// https://www.ideserve.co.in/learn/longest-substring-with-non-repeating-characters
// https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring/0
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class SlidingWin_LenOfLongestSubstringNoRepChars {

	private static int getLengthOfLongestSubstringNoRepeatingChars (String s) {

		if(s == null || s.length() == 0) return 0;

		Set<Character> set = new HashSet<>();
		int start = 0;
		int end = 0;
		int maxLen = Integer.MIN_VALUE;

		for(end = 0; end < s.length(); end++) {
			char endChar = s.charAt(end);

			while(set.contains(endChar)) {
				set.remove(s.charAt(start));
				++start;
			}
			set.add(endChar);
			maxLen = Math.max(maxLen, set.size());
		}
		return maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String str = br.readLine().trim(); 
	        //int len = lengthOfLongestSubstring(str);
	        //System.out.println(len);
			System.out.println(getLengthOfLongestSubstringNoRepeatingChars(str));
		}
	}
	
	/*static int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        
        HashSet<Character> set = new HashSet<Character>();
        int i = 0, j = 0;
        while ( j < s.length() ) {
			
        	if(!set.contains(s.charAt(j))) {
        		set.add(s.charAt(j));
        		j++;
        		System.out.println("j "+j+" i "+i);
        		maxLength = Math.max(maxLength, j-i);
        	}
        	else {
        		set.remove(s.charAt(i));
        		System.out.println("j "+j+" i "+i);
        		i++;
        	}
        	System.out.println(set);
		}
        return maxLength;
    }*/
}
