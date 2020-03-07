import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LeftOutCandies {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), m = Integer.parseInt(ip[1]);
			int total = n*(n+1)/2;
			int rem = m%total, i=1;
			if(rem==0) {
				System.out.println(rem);
			}
			else {
				while(true) {
					rem = rem - i;
					i++;
					if(i > rem) {
						System.out.println(rem);
						break;
					}
				}
			}
		}
	}
}
