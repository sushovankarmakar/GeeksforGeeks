import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SeriesX1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int op = (n*n*n)+n;
			System.out.println(op);
		}
	}
}
