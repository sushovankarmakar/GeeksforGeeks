import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MinProductPair {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			long ip[] = new long[n];
			long min = Long.MAX_VALUE, diff = Long.MAX_VALUE, min2, minPosition=0;
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Long.parseLong(s[i]);
				if(ip[i]<min) {
					min = ip[i];
					minPosition = i;
				}
			}
			
			min2 = min;
			for (int i = 0; i < ip.length; i++) {
				
				long d = ip[i] - min; 
				if( (minPosition!=i) && (d <= diff) ) {
					min2 = ip[i];
					diff = d;
				}
			}
			System.out.println(min*min2);
		}
	}
}
