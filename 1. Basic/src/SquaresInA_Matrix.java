import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-number-of-squares-in-a-rectangle/

class SquaresInA_Matrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(ip[0]), n = Integer.parseInt(ip[1]);
			long op = 0;
			while(m >0 && n>0) {
				op += (m--)*(n--);
			}
			System.out.println(op);
		}
	}
}
