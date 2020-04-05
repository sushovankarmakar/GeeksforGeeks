import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://ide.geeksforgeeks.org/QfXZELSri2
// https://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
// Previously this class was named as FourElements 

class FourElementsWithSumToGivenSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String arr[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(arr[i]);
			}
			int x = Integer.parseInt(br.readLine().trim());
			
			//System.out.println(combinationFound(ip,x));
			
			Arrays.sort(ip);
			System.out.println(combinationFound(ip,x));
		}
	}
	
	// O(n^3) solution  , execution time: 0.1
	static int combinationFound(int ip[], int x) {
		int n = ip.length;
		for (int i = 0; i < n-3; i++) {
			for (int j = i+1; j < n-2; j++) {
				
				int l = j+1, r = n-1;
				while(l < r) {
					if(ip[i]+ip[j]+ip[l]+ip[r]== x) {
						return 1;
					}
					else if ( ip[i]+ip[j]+ip[l]+ip[r] > x ) r--;
					else l++;
				}
			}
		}
		return 0;
	}
	
	
	// O(n^4) solution , execution time: 0.13 
	/*static int combinationFound(int ip[], int x) {
		int n = ip.length;
		for (int i = 0; i < n-3; i++) {
			for (int j = i+1; j < n-2; j++) {
				for (int k = j+1; k < n-1; k++) {
					for (int l = k+1; l < n; l++) {
						if(ip[i]+ip[j]+ip[k]+ip[l]== x) {
							return 1;
						}
					}
				}
			}
		}
		return 0;
	}*/
}
