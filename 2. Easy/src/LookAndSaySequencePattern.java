import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// https://www.geeksforgeeks.org/look-and-say-sequence/
// https://practice.geeksforgeeks.org/problems/decode-the-pattern/0
// https://mathworld.wolfram.com/LookandSaySequence.html


public class LookAndSaySequencePattern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(findThePattern(n));
		}
	}
	
	private static String findThePattern(int n) {
		
		String str = "1";
		for(int i = 1; i < n; i++) {
			
			str += "$";
			int count = 1;
			String temp = "";
			
			for(int j = 0; j < str.length() -1; j++) {
				
				if(str.charAt(j) != str.charAt(j+1)) {
					temp += ( String.valueOf(count) + str.charAt(j));
					count = 0;
				}
				count++;
			}
			str = temp;
		}
		return str;
	}
}
