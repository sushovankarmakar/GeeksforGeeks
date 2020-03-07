import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/square-root-of-an-integer/


class CountSquares {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			System.out.println((long)Math.sqrt(n-1));
		}
	}
}
