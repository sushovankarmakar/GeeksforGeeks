import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.geeksforgeeks.org/difference-of-two-large-numbers/

class Compare2LargeNo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			
			BigInteger a = new BigInteger(br.readLine()), b = new BigInteger(br.readLine());
			StringBuffer sb = new StringBuffer();
			//String a = br.readLine().trim() , b = br.readLine().trim();
			int result = a.compareTo(b);
			if(result == -1) {  // a < b
				sb.append("1");
			}
			else if(result == 1) { // a > b
				sb.append("2");
			}
			else if(result == 0){  // a ==  b
				sb.append("3");
			}
			System.out.println(sb);
		}
	}
}
