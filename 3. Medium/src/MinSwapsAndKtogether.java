import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://hackerranksolutionc.blogspot.com/2018/03/minimum-swaps-and-k-together-java.html
// https://practice.geeksforgeeks.org/editorial.php?pid=3160

class MinSwapsAndKtogether {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int k = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			int totalSmallerElement = 0;
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				if(ip[i] <= k ) totalSmallerElement++;
			}
			
			int largerElementInWindow = 0;
			for (int i = 0; i < totalSmallerElement; i++) {
				if(ip[i] > k) largerElementInWindow++;
			}
			
			int op = largerElementInWindow;
			for (int i = 0, j = totalSmallerElement; j < n; i++, j++) {
				if(ip[i] > k) largerElementInWindow --;
				if(ip[j] > k) largerElementInWindow ++;
				op = Math.min(largerElementInWindow, op);
			}
			System.out.println(op);
		}
	}
}
