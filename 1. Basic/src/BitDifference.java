import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/count-number-of-bits-to-be-flipped-to-convert-a-to-b/

class BitDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			/*String a = Integer.toString(Integer.parseInt(s[0]), 2);
			String b = Integer.toString(Integer.parseInt(s[1]), 2);
			*/
			long a = Long.valueOf(s[0]);
			long b = Long.valueOf(s[1]);
			
			System.out.println(Long.bitCount(a^b));
		}
	}
}
