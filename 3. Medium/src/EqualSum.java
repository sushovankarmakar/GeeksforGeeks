import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/
//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/

class EqualSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				try {
					ip[i] = Integer.parseInt(s[i]);
				}
				catch(Exception ex) {}
			}
			int l = 0, r = n-1;
			boolean b = true;
			while(r-l > 1) {
				//checking which one is greater - ip[l] or ip[r]
				if(ip[l]<=ip[r]) { // left side is greater than or equal to right side
					ip[r] = ip[r]-ip[l];
					
					ip[l] = 0; l++;
					if(ip[r]==0) r--;
				}
				else {  // right side is greater than left side
					ip[l] = ip[l]-ip[r];
	
					ip[r] = 0; r--;
					if(ip[l]==0) l++;
				}
			}
			
			int countNonZero = 0;
			for (int i = 0; i < ip.length; i++) {
				if(ip[i]!=0) countNonZero++;
				if(countNonZero > 1) {
					b = false;
					break;
				}
			}
			System.out.println(b?"YES":"NO");
		}
	}
}
