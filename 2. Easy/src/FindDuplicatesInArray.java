import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindDuplicatesInArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			for (int i = 0; i < n; i++) {
				ip[ip[i]%n] += n; 
			}
			
			for (int i = 0; i < n; i++) {
				System.out.print(ip[i]+" "); 
			}
			System.out.println();
			
			boolean b = false;
			for (int i = 0; i < n; i++) {
				if((ip[i]/n) > 1) {
					b = true;
					System.out.print(i+" ");
				}
			}
			if(!b) System.out.println("-1");
		}
	}
}
