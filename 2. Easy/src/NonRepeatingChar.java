import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class NonRepeatingChar {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			char ip[] = br.readLine().trim().toCharArray();
			int freq[] = new int[26];
			for (int i = 0; i < n; i++) {
				freq[ip[i]-97]++;
			}
			boolean b = false;
			for (int i = 0; i < n; i++) {
				if(freq[ip[i]-97]==1) {
					System.out.println(ip[i]);
					b = true;
					break;
				}
			}
			if(!b)System.out.println("-1");
		}
	}
}
