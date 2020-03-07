import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// there was a problem in java compiler so submitted the same solution in c++ compiler.
// https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/

class RowWithMax1s {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nm[] = br.readLine().trim().split("\\s+")/*, ip[] = br.readLine().trim().split("\\s+")*/; 
			Scanner sc = new Scanner(System.in);
			int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
			//System.out.println(n+" "+m);
			int matrix[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			int firstOneOccur = Integer.MAX_VALUE;
			int row = 0;
			int position = 0;
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < m; j++) {
					/*if(Integer.parseInt(ip[i*n + j])==1) {
						position = j;
						break;
					}*/
					if(matrix[i][j]==1) {
						position = j;
						break;
					}
				}
				if(firstOneOccur > position ) {
					firstOneOccur = position;
					row = i;
				}
			}
			System.out.println(row);
		}
	}
}
