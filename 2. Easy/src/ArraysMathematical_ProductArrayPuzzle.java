import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/product-array-puzzle/0
// shorturl.at/esxBO
// https://www.geeksforgeeks.org/product-array-puzzle-set-2-o1-space/

/*
	Use property of log to multiply large numbers
	x = a * b * c * d
	log(x) = log(a * b * c * d)
	log(x) = log(a) + log(b) + log(c) + log(d)
	x = antilog(log(a) + log(b) + log(c) + log(d))
*/

public class ArraysMathematical_ProductArrayPuzzle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split("\\s+");
			int[] ip = new int[n];
			int totalProduct = 1;
			for(int i = 0; i < n; i++) {
			    ip[i] = Integer.parseInt(str[i]);
			    totalProduct *= ip[i];
			}
			
			StringBuilder op = new StringBuilder();
			for(int i = 0; i < n; i++) {
				
				// we know x/y mathematically is same  
		        // as x*(y to power -1) 
			    int ans = (int) (totalProduct * Math.pow(ip[i], -1)); 	// division operator was giving TLE.
			    op.append((ans + " "));
			}
			System.out.println(op.toString().trim());
		}
	}
}
