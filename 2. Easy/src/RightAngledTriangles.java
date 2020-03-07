import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-whether-right-angled-triangle-valid-not-large-sides/

class RightAngledTriangles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			long a = Long.parseLong(ip[0]), b = Long.parseLong(ip[1]), c = Long.parseLong(ip[2]);
			long max = Math.max(a, Math.max(b, c));
			a = a*a; 
			b = b*b; 
			c = c*c;
			max = max*max;
			System.out.println( (a+b==max) || (b+c==max) || (c+a==max) ? "Yes" : "No" );
		}
	}
}
