import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x/0
// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/


// one function call approach
// https://www.youtube.com/watch?v=dVXy6hmE_0U (Good Video Explanation) <- this approach is followed in below solution
// https://www.geeksforgeeks.org/first-strictly-greater-element-in-a-sorted-array-in-java/
class Searching_FirstAndLastOccurrencesOfX {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			String s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]);
			int target = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			int firstPosition = findPosOfFirstNumGreaterThanOrEqualTarget(ip, target);
			int lastPosition  = findPosOfFirstNumGreaterThanOrEqualTarget(ip, target + 1) - 1;

			if(firstPosition <= lastPosition) {
				System.out.println(firstPosition + " " + lastPosition);
			}
			else {
				System.out.println("-1");
			}
		}
	}

	private static int findPosOfFirstNumGreaterThanOrEqualTarget(int[] ip, int target) {
		if(ip == null || ip.length == 0) return -1;

		int n = ip.length;
		int low  = 0;
		int high = n - 1;
		int position = n;

		while(low <= high) {
			int mid = low + (high - low)/2;

			if(target <= ip[mid]) {
				position = mid; // saving this position for possible answer
				high = mid - 1; // and then go to the left
			}
			else {  // ip[mid] < target
				low = mid + 1;
			}
		}
		return position;
	}
}

// below is the two function call solution
// https://www.youtube.com/watch?v=pLT_9jwaPLs
// https://www.youtube.com/watch?v=OE7wUUpJw6I
// https://www.youtube.com/watch?v=bU-q1OJ0KWw

/*class Searching_FirstAndLastOccurrencesOfX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			String s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]);
			int target = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			int firstPosition = findFirstPosition(ip, target);
			int lastPosition  = findLastPosition(ip, target);

			if(firstPosition == -1){
				System.out.println("-1");
			} else {
				System.out.println(firstPosition + " " + lastPosition);
			}
		}
	}

	private static int findFirstPosition(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int position = -1;

		while(low<=high) {
			int mid = low + (high-low)/2;

			if(nums[mid] == target) {
				position = mid; // saving this position for possible answer
				high = mid - 1; // going more left to find the first position of target
			}
			else if(target < nums[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return position;
	}

	private static int findLastPosition(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int position = -1;

		while(low<=high) {
			int mid = low + (high - low)/2;

			if(nums[mid] == target) {
				position = mid; // saving this position for possible answer
				low = mid + 1; // going more right to find the last position of target
			}
			else if(target < nums[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return position;
	}
}*/

/*
// below approach is follow this link
// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/

class Searching_FirstAndLastOccurrencesOfX {

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
			if(firstOccurrence!=-1) {
				// if first occurrence is found, only then go for last occurrence of the element
				// we reverse the first and last index and try to find the first occurrence of x from last index,
				// which will be the last occurrence of x from first index

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
				//two possibilities are here
				//1. 	if mid is the first index i.e mid==0 and x==ip[mid], then mid point is the first occurrence of x
				//or 2. if x is greater than previous element of ip[mid] i.e x > ip[mid-1]
				//and x==ip[mid], then mid point is the first occurrence of x

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
*/
