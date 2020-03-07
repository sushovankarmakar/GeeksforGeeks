import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-number-is-perfect-square-using-additionsubtraction/
// https://blog.jgc.org/2008/02/sum-of-first-n-odd-numbers-is-always.html

class CheckPerfectSquare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int a = (int)Math.sqrt(n);
			double b = Math.sqrt(n);
			System.out.println((a==b)?"1":"0");
		}
	}
}
