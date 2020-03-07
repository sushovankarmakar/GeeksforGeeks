import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/print-matrix-snake-pattern/

class MatrixInSnakePattern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				if(i%2==0) { // if i is even
					for (int j = 0; j < n; j++) {
						sb.append(s[(i)*n + j]+" ");
					}
				}
				else if(i%2==1){ // if i is odd
					for (int j = 1; j <= n ; j++) {
						sb.append(s[(i+1)*n - j]+" ");
					}
				}
			}
			System.out.println(sb);
		}
	}
}
