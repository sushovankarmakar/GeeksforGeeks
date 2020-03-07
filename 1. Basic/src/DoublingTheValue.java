import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class DoublingTheValue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]);
			long b = Long.parseLong(s1[1]);
			String s2[] = br.readLine().trim().split("\\s+");
			long ip[] = new long[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Long.parseLong(s2[i]);
				if(ip[i]==b) {
					ip[i] = b*2;
					b = ip[i]; 
				}
			}
			System.out.println(b);
		}
	}
}
