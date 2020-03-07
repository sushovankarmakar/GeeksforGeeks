import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SubsetSumProblem {

	static boolean m[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), sum = 0;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				sum += ip[i];
			}
			if(sum%2 != 0) { 
				System.out.println("NO");  /* if sum is not even then we can't make two subsets such 
											   that the sum of elements in both subsets is same */
			}
			else if(partition(ip,sum/2)==true){  //subset of numbers in this array which adds up to given total
				System.out.println("YES");
			}
			/*else if(partition(ip,n,sum/2)==true){ 
				System.out.println("YES");
			}*/
		}
	}
	
	/*//recursive approach, works fine but takes a lot time, I was getting time limit exceed problem.
	static boolean partition(int ip[],int n,int sum) {
		//base cases
		if(sum==0) return true;
		if(n==0 && sum!=0) return false;
		
		if(ip[n-1]>sum) return partition(ip,n-1,sum);
		
		return partition(ip,n-1,sum) || partition(ip,n-1,sum-ip[n-1]);
	}*/
	//dynamic approach, works for only small amount of sum
	  	static boolean partition(int ip[],int sum) {
		m = new boolean[ip.length+1][sum+1];
		for (int i = 0; i <= ip.length; i++) {
			m[i][0] = true;
		}
		for (int j = 1; j <= sum; j++) {
			m[0][j] = false;
		}
		
		for (int i = 1; i <= ip.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if(j < ip[i-1] ) {
					m[i][j] = m[i-1][j];  //if sum is less than the value then that value won't play any role, 
										  //so just get the value from the top 
				}
				else {
					m[i][j] = m[i-1][j] || m[i-1][ j-ip[i-1] ];
				}
			}
		}
		
		return m[ip.length][sum];
	}
}
