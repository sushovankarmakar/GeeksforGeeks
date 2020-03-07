import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Missing_number_in_array {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			//find the sum of given n-1 numbers and then take the sum of first n natural numbers. answer is the difference between these two sums 
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int in[] = new int[s.length];
			int sum1=0;
			for (int i = 0; i < in.length; i++) {
				in[i] = Integer.parseInt(s[i]);
				sum1 += in[i];
			}
			int sum2 = n*(n+1)/2;
			System.out.println(sum2-sum1);
		}
	}
	
	// we can also do it using XOR operation

}
