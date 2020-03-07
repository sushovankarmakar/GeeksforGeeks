import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class KthElemntOf2SortedArr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nmk[] = br.readLine().trim().split("\\s+"), 
					ip1[] = br.readLine().trim().split("\\s+"),
					ip2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nmk[0]), m = Integer.parseInt(nmk[1]), k = Integer.parseInt(nmk[2]);
			int a[] = new int[n], b[] = new int[m];
			for (int i = 0; i < n; i++) {	a[i] = Integer.parseInt(ip1[i]);}
			for (int i = 0; i < m; i++) {	b[i] = Integer.parseInt(ip2[i]);}
			
			//System.out.println(kth(a,0,n,b,0,m,k-1));
			System.out.println(kth(a,b,k));
		}
	}
	
	
	// this function is quite related to merge function in merge sort algorithm
	static int kth(int a[],int b[],int k) {
		int m = a.length, n = b.length;
		int i = 0,j = 0, d = 0;
		while( i<m && j<n) {
			if(a[i] < b[j]) {
				if(++d == k) return a[i];
				i++;
			}
			else {
				if(++d==k) return b[j];
				j++;
			}
		}
		
		while(i<m) {
			if(++d == k) return a[i];
			i++;
		}
		
		while(j<n) {
			if(++d == k) return b[j];
			j++;
		}
		
		return -1;
	}
	
	
	
	// NEED HELP
	// I tried so hard to solve this problem in o(log(n)), but somehow got wrong result
	// tried every possible solution
	// https://algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/
	// https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
	// https://stackoverflow.com/questions/4607945/how-to-find-the-kth-smallest-element-in-the-union-of-two-sorted-arrays
	
	/*static int kth(int a[],int l1,int r1,int b[],int l2,int r2,int k) {
		
		if(k < 0 || k > (r1+r2) ) return -1;
		
		// base conditions
		if(l1 == r1) 	{
			System.out.println("b[k] " + b[k]);
			return b[k]; // when 1st array is finished, return the kth value of 2nd array
		}
		if(l2 == r2)	{
			
			System.out.println("a[k] " + a[k]);
			return a[k]; // when 2nd array is finished, return the kth value of 1st array
		}
		
		if(k==1) return Math.min(a[0], b[0]);
		
		int mid1 = (r1 - l1)/2 , mid2 = (r2 - l2)/2 ;
		
		System.out.println("mid1 " + mid1 + " mid2 " +mid2);
		
		if(mid1 + mid2 < k) {
			if(a[mid1] > b[mid2]) {
				System.out.println("1");
				System.out.println("k "+ (k-mid2-1) );
				return kth(a, l1, r1, b, l2+mid2+1, r2, k-mid2-1);  // ignore the 1st half of b
			}
			else {
				System.out.println("2");
				System.out.println("k "+ (k-mid1-1) );
				return kth(a, l1+mid1+1, r1, b, l2, r2, k-mid1-1);  // ignore the 1st half of a
			}
				
		}
		else { // ( k < mid1 + mid2 )
			
			if(a[mid1] > b[mid2]) {
				System.out.println("3");
				System.out.println("k "+ k);
				return kth(a, l1, l1+mid1, b, l2, r2, k); // ignore the 2nd half of a
			}
			else {
				System.out.println("4");
				System.out.println("k "+ k);
				return kth(a, l1, r1, b, l2, l2+mid2, k); // ignore the 2nd half of b
			}
		}
	}*/
}
