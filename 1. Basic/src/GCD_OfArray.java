import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GCD_OfArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), min = Integer.MAX_VALUE;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				if(ip[i] < min) min = ip[i];
			}
			
			int div = 1, gcd = 1;
			while(div <= min) {
				boolean b = false;
				for (int i = 0; i < ip.length; i++) {
					if(ip[i]%div==0) {
						b = true;
					}
					else {
						b = false;
						break;
					}
				}
				if(b) gcd = div;
				div++;
			}
			System.out.println(gcd);
		}
	}
}
