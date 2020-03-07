import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/

class PeakElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n  = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int index = peakElement(ip,n);
			int f = 0;
			if(n==1) f = 1;
			else if(index ==0 && ip[0] >= ip[1]) f = 1;
			else if(index ==n-1 && ip[n-2] <= ip[n-1]) f = 1;
			else if(ip[index-1] <= ip[index] && ip[index] >= ip[index+1]) f = 1;	
			else f = 0;
			System.out.println(f);
		}
	}
	
	// O(n) solution
	/*public static int peakElement(int a[], int n) {
		
		if (n==1)
			return 0;

		if(a[0] > a[1])
			return 0;
			
		if(a[n-1] > a[n-2])
			return n-1;
			  
		for(int i=1;i<n-1;i++){
			if(a[i] > a[i-1] && a[i] > a[i+1])
				return i;
		}
		return -1;
	}*/
	
	// O(logn) solution
	public static int peakElement(int a[], int n) {
		return findPickElement(a,n,0,n-1);
	}
	
	static int findPickElement(int a[],int n, int low, int high) {
		int mid = low + (high-low)/2;
		if(low <= high) {
			if(( mid==0 || a[mid-1] <= a[mid] ) && ( mid == n-1 || a[mid] >= a[mid+1] )) {
				return mid;
			}
			else if( mid > 0 &&  (a[mid-1] >= a[mid]) ) {
				return findPickElement(a,n, low, mid-1);
			}
			else if( a[mid] <= a[mid+1] ) {
				return findPickElement(a,n, mid+1, high);
			}
		}
		return -1;
	}
}
