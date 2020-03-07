import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MinimumOperations {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int count=1;
			while(n!=1) {
				if(n%2 != 0) {
					n = n-1;
					n = n/2;
					count += 2;
				}
				else {
					n = n/2;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
