import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://ide.geeksforgeeks.org/v6QnWgI9xH
// https://www.ideserve.co.in/learn/longest-substring-with-non-repeating-characters

class LenOfLongestSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String str = br.readLine().trim(); 
	        int len = lengthOfLongestSubstring(str);
	        System.out.println(len);
		}
	}
	
	static int lengthOfLongestSubstring(String s) {
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
    }
}
