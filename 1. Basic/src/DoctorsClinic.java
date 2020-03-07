import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class DoctorsClinic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), x = Integer.parseInt(ip[1]);
			int wait = (n-1)*10 - (n-1)*x;
			System.out.println(wait);
		}
	}
}
