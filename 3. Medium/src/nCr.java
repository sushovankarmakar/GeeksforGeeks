import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// here nPr, coefficient of binomial expansion and pascal's triangle matrix concept has been used.
// https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
// https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
// http://www.ltcconline.net/greenl/courses/154/seqser/binomial.htm

//  three approaches are here. 1. recursive 2. dynamic 3. space efficient dynamic 

class nCr {

	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);
			if(n<r) {
				System.out.println("0");
			}
			else {
				// dynamic approach
				/*int op[][] = new int[n+1][n+1];
				for (int i = 0; i <= n; i++) {
					 for (int j = 0; j <= (int)Math.min(i, r); j++) {
						if(j==0 ||j==i) op[i][j]=1;
						else
							op[i][j] = ((op[i-1][j-1]%mod) + (op[i-1][j]%mod))%mod;
					}
				}
				//printing purpose , it will print a matrix which is Pascal's Triangle matrix
				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= n; j++) {
						System.out.print(op[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println(op[n][r]%mod);*/
				
				
				//space efficient approach  
				/*optimized to use O(n) extra space as we need values only from previous row. 
				So we can create an auxiliary array of size n and overwrite values.*/
				int op[] = new int[n+1];
				op[0] = 1;
				for (int i = 1; i <= n; i++) {
					for (int j = (int)Math.min(i, r); j > 0; j--) {
						op[j] = op[j] + op[j-1];
					}
					for (int j = 0; j <=n; j++) {
						System.out.print(op[j]+" ");
					}
					System.out.println();
				}
				System.out.println(op[r]);
			}
			
			//recursive way
			/*int op = bCoefficient(n, r)%mod;
			System.out.println(op);*/
		}
	}
	
	// this is the recursion approach, which takes too much time. instead of this, use dynamic approach
	/*static int bCoefficient(int n,int r) {
		if(r==0 || r==n) return 1;
		else {
			return  (bCoefficient(n-1, r-1)%mod + bCoefficient(n-1, r)%mod)%mod;
		}
	}*/
}
