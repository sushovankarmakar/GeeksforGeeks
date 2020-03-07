import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/

class FindingTheNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),x=0,y=0,xor = 0,xor_setBit_no=0;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[(n*2) + 2];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				xor = xor^ip[i];
			}
			//System.out.println(xor);
			xor_setBit_no = xor & ~(xor-1);
			for (int i = 0; i < ip.length; i++) {
				if( (ip[i] & xor_setBit_no) > 0) {
					x = x^ip[i];
				}
				else {
					y = y^ip[i];
				}
			}
			System.out.println( (x<y) ? x+" "+y : y+" "+x );
		}
	}
}
