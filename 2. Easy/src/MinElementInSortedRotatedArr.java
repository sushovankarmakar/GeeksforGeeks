import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class MinElementInSortedRotatedArr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int min = binary_search(ip, 0, ip.length-1);
			System.out.println(min);
			
		}
	}
	
	static int binary_search(int a[],int l,int r) {
				
		if( a[l] < a[r] ) {
			//System.out.println("Array is not rotated at all");
			return a[0];
		}
		while(l<=r) {
			if (l==r) {
				//System.out.println("Only one element");
				return a[l];
			}
			
			int mid = l+(r-l)/2;
			//System.out.println("mid = "+mid);
			
			if(mid > l && a[mid] < a[mid-1])   {
				//System.out.println("Min is exactly at the middle");
				return a[mid];
			}
			if(mid < r && a[mid] > a[mid+1])   {
				//System.out.println("Min is exactly after the middle");
				return a[mid+1];
			}
			
			if(a[r] > a[mid]) {
				//System.out.println("Mid is on the left side");
				r = mid-1;
			}
			else {
				//System.out.println("Mid is on the right side");
				l = mid+1;
			}
			
		}
		return -1;
	}
}





//simple approach
/*
boolean b = false;
for (int i = 0; i < n-1; i++) {
	if(ip[i] <ip[i+1]) {
		
	}
	else {
		System.out.println(ip[i+1]);
		b = true;
		break;
	}
}
if(!b) System.out.println(ip[0]);
*/
