import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MakeThem1Java {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String rc[] = br.readLine().trim().split("\\s+");
			int r = Integer.parseInt(rc[0]), c = Integer.parseInt(rc[1]);
			int mat[][] = new int[r][c];
			for (int i = 0; i < r; i++) {
				String ip[] = br.readLine().trim().split("\\s+");
				for (int j = 0; j < ip.length; j++) {
					mat[i][j] = Integer.parseInt(ip[j]);
				}
			}
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-----------------");
			
			// algo
			int row[] = new int[r], col[] = new int[c];
			
	        for(int i =0; i < r ; i++){
	            for(int j=0; j < c; j++){
	                if(mat[i][j]==1) {
	                	row[i] = 1;
	                	col[j] = 1;
	                }
	            }
	        }
	        
	        for (int i = 0; i < r; i++) {
				if(row[i]==1) {
					for (int j = 0; j < c; j++) {
						mat[i][j] = 1;
					}
				}
			}
	        for (int i = 0; i < c; i++) {
	        	if(col[i]==1) {
					for (int j = 0; j < r; j++) {
						mat[j][i] = 1;
					}
				}
			}
	        
	        
	        for(int i =0; i < r ; i++){
	            for(int j=0; j < c; j++){
	                System.out.print(mat[i][j]+" ");
	            }
	            System.out.println();
	        }
			
		}
	}
}
