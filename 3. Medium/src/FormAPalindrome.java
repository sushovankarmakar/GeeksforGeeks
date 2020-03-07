import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FormAPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			System.out.println(findMinNumberInsertion(ip,ip.length()));
		}
	}
	
	static int findMinNumberInsertion(String ip, int n) {
		int table[][] = new int[n][n];
		
		for (int gap = 1; gap < n; gap++) {
			for (int l = 0, h = gap; h < n; l++, h++) {
				table[l][h] = (	ip.charAt(l)==ip.charAt(h) ) ?	table[l+1][h-1]: 
					Math.min(table[l][h-1], table[l+1][h])+1;
			}
		}
		return table[0][n-1];
	}
}
