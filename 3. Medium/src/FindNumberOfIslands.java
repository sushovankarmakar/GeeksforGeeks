import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-number-of-islands/
// no java compiler was there in GFG, so code submitted in C++;

class FindNumberOfIslands {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+"), a[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), m = Integer.parseInt(ip[1]);
			int mat[][] = new int[n][m];
			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = Integer.parseInt(a[k]);
					k++;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}
			boolean visited[][] = new boolean[n][m];
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(mat[i][j]==1 && !visited[i][j]) {
						count++;
						dfs(i,j,mat,visited);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static int offSet[] = {-1,0,1};
	
	static boolean findNotVisitedNeighbours(int i ,int j, int mat[][] ,boolean visited[][]) {
		if( (i >=0 && i < mat.length) && (j >=0 && j < mat[0].length) ) {
			if(mat[i][j]==1 && !visited[i][j]) return true;
		}
		return false;
	}
	
	static void dfs(int i,int j,int mat[][],boolean visited[][]) {
		
		visited[i][j] = true;
		
		for (int x = 0; x < offSet.length; x++) {
			int xOffSet = offSet[x];
			for (int y = 0; y < offSet.length; y++) {
				int yOffSet = offSet[y];
				
				if(xOffSet ==0 && yOffSet ==0) continue;
				
				if(findNotVisitedNeighbours( i+xOffSet, j+yOffSet, mat, visited)) dfs( i+xOffSet, j+yOffSet , mat, visited);
			}
		}
	}
}
