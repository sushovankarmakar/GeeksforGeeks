import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SteppingNumbers {

	//this is an iterative method, we can also solve this using BFS/DFS
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int count = 0;
			for (int i = n; i <= m; i++) {
				if(isSteppingNo(i)) {
					//System.out.println(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
	 public static boolean isSteppingNo(int n) {
		int prev_d = -1;  // taking the previous digit, initializing as -1 
		
		while(n!=0) {
			int curr_d = n%10;  // taking the current digit
			
			//single digit is considered as stepping number
			if(prev_d != -1) {
				if(  Math.abs(prev_d-curr_d)!=1 ) {
					
					return false;
				}
			}
			prev_d = curr_d;
			n /= 10;
		}
		return true;
	}
}
