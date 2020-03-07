import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/boundary-elements-matrix/

class BoundaryElementsOfMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			//int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				if(i==0 ) {
					for (int j = 0; j < n; j++) {
						sb.append(s[i+j]+" ");
					}
				}
				else if(i == n-1) {
					for (int j = 0; j < n; j++) {
						sb.append(s[(i*n)+j]+" ");
					}
				}
				else {
					sb.append(s[i*n]+" "+s[ (i+1)*n - 1 ]+" ");
				}
			}
			System.out.println(sb);
 		}
	}
}
