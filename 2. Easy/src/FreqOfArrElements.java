import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FreqOfArrElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int ip[] = new int[n];
			
			//int op[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				//op[ip[i]-1]++;
			}
			
			for (int i = 0; i < ip.length; i++) {
				ip[i] = ip[i]-1;
			}
			
			for (int i = 0; i < ip.length; i++) {
				ip[ip[i]%n] = ip[ip[i]%n] + n;
			}
			
			
			for (int i=0; i < ip.length; i++) {
				sb.append( (ip[i]/n) +" ");
			}
			System.out.println(sb);
		}
	}
}
