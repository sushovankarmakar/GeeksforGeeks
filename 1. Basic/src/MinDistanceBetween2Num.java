import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

class MinDistanceBetween2Num {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+"), ip1[] = br.readLine().trim().split("\\s+");
			long x = 0, y= 0, minDist = Long.MAX_VALUE;
			for (int i = 0; i < ip1.length; i++) {
				x = Long.parseLong(ip1[0]); y = Long.parseLong(ip1[1]); 
				if(i==1) {
					long temp = x;
					x = y;
					y = temp;
				}
				
				boolean b = false;
				long count = Long.MAX_VALUE;
				for (int j = 0; j < ip.length; j++) {
					long a = Long.parseLong(ip[j]);
					
					if(a==x) {
						b = true;
						count = -1;
					}
					if(b) count++;
					if(a==y) {
						b = false;
						if(count < minDist) {
							minDist = count;
						}
					}
				}
			}
			System.out.println(minDist==Long.MAX_VALUE?"-1":minDist);
		}
	}
}
