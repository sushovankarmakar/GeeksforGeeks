import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PenaltyShooters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int x = Integer.parseInt(ip[0]), y = Integer.parseInt(ip[1]), z = Integer.parseInt(ip[2]);
			int a = 0, b = 0;
			while(z > 1) {
				if( ( x % z ) == 0 ) {
					x--;
					a++;
				}
				else if( ( y % z ) == 0 ) {
					y--;
					b++;
				}
				else {
					z--;
				}
			}
			System.out.println(a+" "+b);
		}
	}
}
