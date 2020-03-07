import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaxValue_in_BitonicArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			int max = Integer.parseInt(s[0]);
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				if(ip[i]>max) max = ip[i];
			}
			System.out.println(max);
		}
	}
}
