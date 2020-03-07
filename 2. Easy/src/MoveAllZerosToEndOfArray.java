import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/move-zeroes-end-array/

public class MoveAllZerosToEndOfArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int countZero = 0;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				int val = Integer.parseInt(s[i]);
				if(val!=0) sb.append(val+" ");
				else countZero++;
			}
			
			while(countZero-- > 0) {
				sb.append(0+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}