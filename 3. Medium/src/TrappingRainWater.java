import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// https://www.geeksforgeeks.org/trapping-rain-water/


class TrappingRainWater {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			int left[] = new int[n];
			int right[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(s[i]); 
			}
			left[0]=a[0];
			right[n-1]=a[n-1];
			for (int i = 1; i < n; i++) {
				left[i] = Math.max(a[i-1], left[i-1]); 
			}
			//finding right side max of 
			for (int i = n-2; i >=0; i--) {
				right[i] = Math.max(a[i+1], right[i+1]); 
			}
			
			int op= 0;
			for (int i = 0; i < n; i++) {
				if( left[i]>a[i] && right[i]>a[i] ) {
					op += Math.min(left[i],right[i]) - a[i];
				} 
			}
			System.out.println(op);
		}
	}
}



/*a[i] = Integer.parseInt(s[i]);
if(first > a[i])
{
	op = op + (first - a[i]);
}
else
{
	first = a[i];
}*/