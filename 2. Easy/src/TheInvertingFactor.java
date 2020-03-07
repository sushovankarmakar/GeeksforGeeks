import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class TheInvertingFactor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), minDiff = Integer.MAX_VALUE;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(new StringBuffer(s[i]).reverse().toString());
				//System.out.print(ip[i]+" ");
			}
			Arrays.sort(ip);
			for (int i = 0; i < ip.length-1; i++) {
				int d = Math.abs(ip[i]-ip[i+1]);
				if(d < minDiff) minDiff = d;
			}
			System.out.println(minDiff);
		}
	}
}
