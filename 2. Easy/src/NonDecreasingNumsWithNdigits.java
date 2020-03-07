import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class NonDecreasingNumsWithNdigits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()); 
			long arr[] = new long[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = 1;
			}
			long op = 10;
			if(n == 1) {
				System.out.println(op);
			}
			else {
				
				while( n-->1 ) {
					op += arr[0];
					for (int i = 1; i < 9; i++) {
						arr[i] = arr[i] + arr[i-1];
						op += arr[i];
					}
				}
				System.out.println(op);
			}
		}
	}
}
