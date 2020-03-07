import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// same problem
// https://practice.geeksforgeeks.org/problems/break-numbers/0

class Break_a_Number {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			long op = (n+1)*(n+2)/2;
			System.out.println(op);
		}
	}
}
