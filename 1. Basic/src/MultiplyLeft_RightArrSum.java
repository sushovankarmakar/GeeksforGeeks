import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MultiplyLeft_RightArrSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			
			int mid = n/2, leftSum = 0, rightSum = 0;
			for (int i = 0; i < n; i++) {
				 if(i < mid) {
					 leftSum += Integer.parseInt(s[i]);
				 }
				 else {
					 rightSum += Integer.parseInt(s[i]);
				 }
			}
			System.out.println(leftSum*rightSum);
		}
	}
}
