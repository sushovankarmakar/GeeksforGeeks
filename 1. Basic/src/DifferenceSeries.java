import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// just print n*(2*n+1)
// output: sum of squares of first n even natural numbers - sum of squares of first n odd natural numbers.

class DifferenceSeries {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int base = 3, diff = 7;
			for (int i = 1; i < n; i++) {
				base = (base + diff);
				diff += 4;
			}
			System.out.println(base);
		}
	}
}
