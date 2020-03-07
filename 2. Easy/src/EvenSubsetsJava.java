import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/power-set/
// https://www.hackerearth.com/practice/notes/fun-with-bits-print-all-subsets-of-a-set/

class EvenSubsetsJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			int powerSetSize = (int) Math.pow(2, n);
			
			int count = 0;
			
			for (int i = 0; i < powerSetSize; i++) {
				
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if( (i & (1<<j)) > 0) {
						sum += arr[j];
					}
				}
				
				if((sum & 1) == 0) {
					count++;
				}
			}
			
			// we have to return --count because for first subset we get a black set which is also counted.
			
			System.out.println(--count);
		}
	}
}
