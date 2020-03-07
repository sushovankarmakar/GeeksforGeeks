import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/remove-minimum-number-characters-two-strings-become-anagram/
// AnagramOfString.java

class AlmostEqualJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1 = br.readLine().trim(), s2 = br.readLine().trim();
			int freq[] = new int[26];
			Arrays.fill(freq, 0);
			for (int i = 0; i < s1.length(); i++) {
				freq[s1.charAt(i)-'a']++;
			}
			for (int i = 0; i < s2.length(); i++) {
				freq[s2.charAt(i)-'a']--;
			}
			int sum = 0;
			for (int i = 0; i < freq.length; i++) {
				
				
				// if(freq[i]> 0) sum += freq[i]; this is wrong
				
				/*this below is right because it may happen that second string is larger then value of freq goes in negative*/ 
				sum += Math.abs(freq[i]);  
				
			}
			//System.out.println();
			System.out.println(sum);
		}
	}
}
