import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindingPosition {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			while(n>0) {
				if((n & (n-1))==0) {
					System.out.println(n);
					break;
				}
				n--;
			}
		}
	}
}
