import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Middle_of_Three {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] ip = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(ip[0]);
			int b = Integer.parseInt(ip[1]);
			int c = Integer.parseInt(ip[2]);
			
			if(a>b) {
				System.out.println((b>c)?b:Math.min(a, c));
			}
			else {
				System.out.println((b<c)?b: Math.max(a, c));
			}
		}
	}
}
