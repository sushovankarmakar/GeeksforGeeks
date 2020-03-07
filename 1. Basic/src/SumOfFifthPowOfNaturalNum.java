import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SumOfFifthPowOfNaturalNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			long n = Long.parseLong(br.readLine())+1;
			long sum = 0;
			while(n-->0) {
				long num = n*n*n*n*n;
				sum += num;
			}
			System.out.println(sum);
		}
	}
}
