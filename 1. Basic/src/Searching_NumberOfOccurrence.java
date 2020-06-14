import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
// https://practice.geeksforgeeks.org/problems/number-of-occurrence/0
// https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x/0

//  0 1 2 3 4 5 6
// [5 7 8 8 8 9 10]

// time complex
class Searching_NumberOfOccurrence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			String s2[] = br.readLine().trim().split("\\s+");;
			int n = Integer.parseInt(s1[0]);
			int target = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			System.out.println();

			int firstPosition = findPosOfFirstNumGreaterThanOrEqualTarget(ip, target);
			int lastPosition = findPosOfFirstNumGreaterThanOrEqualTarget(ip, target + 1) -1;

			if(firstPosition <= lastPosition) {
				System.out.println(lastPosition - firstPosition + 1);
			}
			else {
				System.out.println("-1");
			}
		}
	}

	// https://www.geeksforgeeks.org/first-strictly-greater-element-in-a-sorted-array-in-java/
	// https://www.geeksforgeeks.org/first-strictly-smaller-element-in-a-sorted-array-in-java/
	// https://www.youtube.com/watch?v=dVXy6hmE_0U
	// above links are very helpful/similar to understand the below solution

	private static int findPosOfFirstNumGreaterThanOrEqualTarget(int[] ip, int target) {
		if(ip == null || ip.length == 0) return -1;

		int n = ip.length;
		int low = 0;
		int high = n - 1;
		int position = n;   // position n cause position of 8 in [6, 7] is n.

		while(low <= high) {
			int mid = low + (high - low)/2;

			if(target <= ip[mid] ) {
				position = mid;  // saving this position as possible answer
				high = mid - 1; // going left
			}
			else { // ip[mid] < target
				low = mid + 1;
			}
		}
		return position;
	}
}

// using binary search: time complexity : O(log(n)) + O(n) = O(n)
/*
//using binary search
class Searching_NumberOfOccurrence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");;
			int n = Integer.parseInt(s1[0]), x = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			System.out.println(bSearch(ip,0,n-1,x));
		}
	}
	
	static int bSearch(int ip[],int l,int r,int x) {
		
		if(r < l) return -1;
		
		int mid = l + (r-l)/2;
		if(ip[mid]==x) {
			return findX(ip,mid,x);
		}
		else if(ip[mid] < x) return bSearch(ip,mid+1,r,x);
		else return bSearch(ip,l,mid-1,x);	
	}
	
	static int findX(int ip[],int pos,int x) {
		int count = 1;
		int left = pos-1, right = pos+1; 
		
		while( left > 0 && ip[left]==x) {
			count++;
			left--;
		}
		
		while(right < ip.length && ip[right]==x) {
			count++;
			right++;
		}
		return count;
	}
}*/

// using linear search
/*class NumberOfOccurrence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");;
			int n = Integer.parseInt(s1[0]), x = Integer.parseInt(s1[1]), count = 0;
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
				if(ip[i]==x) count++;
				else if(ip[i]!=x && count!=0) break;
			}
			System.out.println(count==0?"-1":count);
		}
	}
}*/
