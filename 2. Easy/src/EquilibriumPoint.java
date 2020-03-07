import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/
//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/

class EquilibriumPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int l = 0, r = n-1;
			while(r-l > 1) {
				//checking between ip[l] and ip[r], which one is greater
				if(ip[l] <= ip[r]) {
					ip[r] = ip[r] - ip[l];
					
					ip[l] = 0; l++;
					if(ip[r]==0) r--;
				}
				else {
					ip[l] = ip[l] - ip[r];
					
					ip[r] = 0; r--;
					if(ip[l]==0) l++;
				}
				
				for (int i = 0; i < n; i++) {
					System.out.print(ip[i]+" ");
				}
				System.out.println();
			}
			
			int countNonZero =0, pos = 0;
			for (int i = 0; i < ip.length; i++) {
				if(ip[i]!=0) {
					countNonZero++;
					pos = i+1;
				}
				
				if(countNonZero > 1) {
					pos = -1;
					break;
				}
			}
			System.out.println(pos);
		}
	}
}
