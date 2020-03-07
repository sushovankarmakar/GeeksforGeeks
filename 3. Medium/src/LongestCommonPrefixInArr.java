import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/
// https://www.geeksforgeeks.org/longest-common-prefix-using-character-by-character-matching/

class LongestCommonPrefixInArr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String nStrings[] = br.readLine().trim().split("\\s+");
			
			int smallestLen = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				smallestLen  = Math.min(smallestLen, nStrings[i].length());
			}
			
			StringBuilder sb = new StringBuilder();
			outer: for (int i = 0; i < smallestLen; i++) {
				for (int j = 0; j < nStrings.length-1; j++) {
					if(nStrings[j].charAt(i) != nStrings[j+1].charAt(i)) {
						break outer;
					}
				}
				sb.append(nStrings[0].charAt(i));
			}
			System.out.println( (sb.length() == 0)? "-1": sb);
		}
	}
}
