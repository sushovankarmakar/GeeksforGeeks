import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaximumDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String ip[] = br.readLine().trim().split("\\s+");
			int diff = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int a = Integer.parseInt(ip[i]);
				if(a < min) min = a;
				
				int d = a-min;
				if(d > diff) diff = d;
			}
			System.out.println(diff==0?"-1":diff);
		}
	}
}
