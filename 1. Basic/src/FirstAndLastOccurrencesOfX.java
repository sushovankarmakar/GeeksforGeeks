import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/


class FirstAndLastOccurrencesOfX {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"),s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]),x = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			int firstOccurrence = findFirstOccurrence(ip, x, 0, n-1);
			int lastOccurrence = 0;
			if(firstOccurrence!=-1) { // if first occurrence is found, only then go for last occurrence of the element
				/* we reverse the first and last index and try to find the first occurrence of x from last index, 
					which will be the last occurrence of x from first index
				*/
				lastOccurrence = findLastOccurrence(ip, x, n-1,0);
			}
			
			System.out.println((firstOccurrence==-1) ? "-1" : firstOccurrence+" "+lastOccurrence);
		}
	}
	
	// used binary search approach to find the first occurrence and last occurrence of x
	
	static int findFirstOccurrence(int ip[],int x,int l,int r) {
		int mid = l +(r-l)/2;
		if(r>=l) {
			if( (mid==0 || (x > ip[mid-1])) &&  (x==ip[mid])  ) {
				/*	two possibilities are here
					1. 	if mid is the first index i.e mid==0 and x==ip[mid], then mid point is the first occurrence of x
					or 2. if x is greater than previous element of ip[mid] i.e x > ip[mid-1] 
							and x==ip[mid], then mid point is the first occurrence of x
				*/
				return mid;
			}
			else if(x <= ip[mid]){
				//if mid element is greater than or equal to x, then find first occurrence x in the left side of the mid
				return findFirstOccurrence(ip, x, l, mid-1);
			}
			else {
				//if mid element is less than x, then find x in the right side of the mid 
				return findFirstOccurrence(ip, x, mid+1, r);
			}
		}
		return -1; // return -1 when we don't find any occurrence of x
	}
	
	static int findLastOccurrence(int ip[],int x,int l,int r) {
		int mid = r +(l-r)/2;
		if(r<=l) {
			if( (mid==l || (x < ip[mid+1])) &&  (x==ip[mid])  ) {
				return mid;
			}
			else if(x >= ip[mid]){
				return findLastOccurrence(ip, x, l, mid+1);
			}
			else {
				return findLastOccurrence(ip, x, mid-1, r);
			}
		}
		return -1; // return -1 when we don't find any last occurrence of x
	}
}
