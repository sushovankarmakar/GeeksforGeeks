import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-if-a-number-is-power-of-another-number/

class IfA_NoIsPowerOfAnotherNo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
			
			// approach-1
			/* 
			int ans=0;
			if(x==1 && y!= 1) {
				// if x==1,then only if y==1 will be true case, other time y!=1 will be false; 
				ans = 0;
			}
			else if(y==1) {  // if y==1 then, power should be 0
				ans = 1;
			}
			else {
				int no = x;
				while(x <= y) {  
					// until the first no crosses second number, multiply the first number with x and any point if x==y, break
					if(x==y) {
						ans = 1;
						break;
					}
					x *= no;
				}
			}
			System.out.println(ans);*/
			
			// approach-2
			/*
			take log of y in base x, if it turns out to be Integer, then true
			 */
			if(x==1) { // if x==1,then only if y==1 will be true case, other time y!=1 will be false; 
				System.out.println((y==1)?"1":"0"); 
			}
			else {
				int res1 = (int) (Math.log(y) / Math.log(x));            
		        double res2 = Math.log(y) /  Math.log(x);
		        System.out.println( (res1==res2)?"1":"0" );
			}
			
		}
	}
}
