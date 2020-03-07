import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/

class FindPairGivenDiff {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]), diff = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < s2.length; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			Arrays.sort(ip);
			/*for (int i = 0; i < ip.length; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();
			System.out.println();*/
			
			int l=0,r=1;
			boolean b = false;
			while( (l<ip.length) && (r < ip.length) ) {
				int d = ip[l]+diff;
				if(d==ip[r]) {
					b = true;
					break;
				}
				else if(d > ip[r]) {
					//System.out.println("l "+l+" r "+r);
					r++;
				}
				else if(d < ip[r]) {
					//System.out.println("l "+l+" r "+r);
					l++;
				}
			}
			System.out.println((b)?"1":"-1");
		}
	}
}
