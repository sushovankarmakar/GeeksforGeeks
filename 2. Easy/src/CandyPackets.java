import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CandyPackets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			long packet = 1;
			while(n > 1 ) {
				packet++;
				n /= 2;
			}
			System.out.println(packet);
		}
	}
}
