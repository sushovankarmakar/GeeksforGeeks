import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//https://ide.geeksforgeeks.org/v6QnWgI9xH
//https://www.ideserve.co.in/learn/longest-substring-with-non-repeating-characters

// O(n) solution is in LenOfLongestSubstring

class LongestDistinctCharString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			
			int maxLength = Integer.MIN_VALUE;
			
			for (int i = 0; i < ip.length(); i++) {
				for (int j = i+1; j <= ip.length(); j++) {
					String tempString = ip.substring(i, j);
					if(isAllDistinctChars(tempString)) {
						maxLength = tempString.length() > maxLength ? tempString.length() : maxLength;
					}
				}
			}
			System.out.println(maxLength);
		}
	}
	
	static boolean isAllDistinctChars(String tempString) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < tempString.length(); i++) {
			Integer val = map.get(tempString.charAt(i));
			if(val != null) {
				map.put(tempString.charAt(i), val+1);
				return false;
			}
			else {
				map.put(tempString.charAt(i), 1);
			}
		}
		return true;
	}
}
