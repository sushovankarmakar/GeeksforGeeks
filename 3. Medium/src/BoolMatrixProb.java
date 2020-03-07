import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BoolMatrixProb {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String[] rc = br.readLine().trim().split(" ");
			int r = Integer.parseInt(rc[0]), c = Integer.parseInt(rc[1]);
			
			int[][] mat = new int[r][c];
            boolean rowFlag = false;
            boolean colFlag = false;
            
            for(int i=0; i < r; i++){
                String[] rowNums = br.readLine().trim().split(" ");
                for(int j=0; j < c; j++){
                    mat[i][j] = Integer.parseInt(rowNums[j]);
                    
                    if(i==0 && mat[i][j]==1) {
	                    rowFlag = true;
	                }
	                if(j==0 && mat[i][j]==1) {
	                    colFlag = true;
	                }
	                if(mat[i][j] == 1){
	                    mat[0][j] = 1;
	                    mat[i][0] = 1;
	                }
                }
            }
            
            for(int i=1; i< r; i++){
	            for(int j=1; j< c; j++){
	                if(mat[0][j] == 1 || mat[i][0] == 1){
	                    mat[i][j] = 1;
	                }
	            }
	        }
	    
	        if(rowFlag){
	            for(int j = 0; j < c; j++){
	                mat[0][j] = 1;
	            }
	        }
	    
	        if(colFlag){
	            for(int i = 0; i < r; i++){
	                mat[i][0] = 1;
	            }
	        }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < r; i++){
                for(int j=0; j < c; j++){
                    sb.append(mat[i][j]+" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            sb.setLength(0);
		}
	}
}