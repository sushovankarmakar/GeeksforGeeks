import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/construct-an-array-from-xor-of-all-elements-of-array-except-element-at-same-index/


class XOR_OfAllElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), xorAll = 0;
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				xorAll ^= ip[i];
			}
			for (int i = 0; i < ip.length; i++) {
				int xor = xorAll^ip[i];
				sb.append(xor+" ");
			}
			System.out.println(sb);
		}
	}
}
