import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.youtube.com/watch?v=oTfPJKGEHcc (Best Explanation)
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array/0
// https://www.youtube.com/watch?v=5BI0Rdm9Yhk

class SearchInRotatedArray {

	// time complexity -> O(log(n)) : this solution find the target element without finding the pivot element.
	// Intuition : If we divide the sorted rotated array into mid, we always get AT LEAST one strictly increasing
	// sub array which is uniform. The pivot part won't in that part. We can use this uniform part and apply
	// binary search on that half.
	private static int findKInRotatedArray(int[] ip, int target) {
		int left = 0, right = ip.length - 1;

		while(left <= right) {
			int mid = left + (right - left)/2;

			if(ip[mid] == target) {
				return mid;
			}
			else if(ip[left] <= ip[mid]) {
				// left to middle is uniform
				if(ip[left] <= target && target <= ip[mid]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			else {
				// middle to right is uniform
				if(ip[mid] <= target && target <= ip[right]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split("\\s+");
			int[] ip = new int[n];
			for(int i = 0; i < n; ++i) {
				ip[i] = Integer.parseInt(str[i]);
			}
			int k = Integer.parseInt(br.readLine().trim());

			System.out.println(findKInRotatedArray(ip, k));
		}
	}


	// O(2log(n)) time complexity
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),max = Integer.MIN_VALUE, rPoint = 0,pos=-1;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			int k = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				if(ip[i]>max) {
					max = ip[i];
					rPoint = i;
				}
			}
			//System.out.println(max+" "+rPoint);
			pos = bSearch(ip,k,0,rPoint);
			if(pos==-1) {
				pos = bSearch(ip,k,rPoint+1,ip.length-1);
			}
			System.out.println(pos);
		}
	}
	
	static int bSearch(int ip[],int k,int l,int r) {
		if(l<=r) {
			int mid = l + (r-l)/2;
			if(ip[mid]==k) return mid;
			else if(ip[mid] > k)	return bSearch(ip,k,l,mid-1);
			else if(ip[mid] < k)	return bSearch(ip,k,mid+1,r);
		}
		return -1;
	}*/
}
