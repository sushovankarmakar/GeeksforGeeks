import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


//https://stackoverflow.com/questions/19372930/given-a-bitonic-array-and-element-x-in-the-array-find-the-index-of-x-in-2logn
// https://practice.geeksforgeeks.org/editorial.php?pid=365

class FindNumberInBitonicArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int x = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			/* here we are finding the position of the maximum value in the bitonic array and then doing binary search
			 * on the right side and left side of the max value
			 * time complexity - 3log(n)  
			*/
			/*int maxPos = findMax(ip,0,n-1);
			int xPos = maxPos; // xPos is the position of x
			if(ip[maxPos]!=x) {
				xPos = findXBeforeMax(ip,x,0,maxPos-1);
				if(xPos==-1) {
					xPos = findXAfterMax(ip,x,maxPos+1,n-1);
				}
			}
			System.out.println(xPos);*/
			int pos = bitonicSearch(ip, x, 0, n-1);
			System.out.println(pos);
		}
	}
	
	/*
	1.	Take the middle of the array
	2.	Compare the middle element with one of its neighbor to see if the max is on the right or on the left
	3.	Compare the middle element with the desired value
	4. 	If the middle element is smaller than the desired value AND the max is on the left side, 
		then do bitonic search on the left subarray (we are sure that the value is not in the right subarray)
	5. 	If the middle element is smaller than the desired value AND the max is on the right side, 
		then do bitonic search on the right subarray
	6. 	If the middle element is bigger than the desired value, 
		then do descending binary search on the right subarray and ascending binary search on the left subarray.
	*/
	static int bitonicSearch(int ip[],int x, int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(r-l==0) { // only one value is there
				return mid;
			}
			else if(r-l==1) {
				if(ip[l]<ip[r]) return r;
				else return l;
			}
			
			if(ip[mid]>ip[mid-1]) { //max is on the left side 
				
				if(x > ip[mid]) bitonicSearch(ip, x, mid+1, r);
				else {
					int pos = ascendingBSearch(ip, x, l, mid-1);
					if(pos==-1) pos = descendingBSearch(ip, x, mid+1, r);
					return pos;
				}
			}
			else {// max is on the right side
				
				if(x > ip[mid]) bitonicSearch(ip, x, mid+1, r);
				else {
					int pos = ascendingBSearch(ip, x, l, mid-1);
					if(pos==-1) pos = descendingBSearch(ip, x, mid+1, r);
					return pos;
				}
			}
		}
		return -1;
	}
	
	static int ascendingBSearch(int ip[],int x,int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(ip[mid]==x) return mid;
			else if(x < ip[mid]) return ascendingBSearch(ip, x, l, mid-1);
			else if(x > ip[mid]) return ascendingBSearch(ip, x, mid+1, r);
		}
		return -1;
	}
	
	static int descendingBSearch(int ip[],int x,int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(ip[mid]==x) return mid;
			else if(x > ip[mid]) return descendingBSearch(ip, x, l, mid-1);
			else if(x < ip[mid]) return descendingBSearch(ip, x, mid+1, r);
		}
		return -1;
	}
	
	/*static int findMax(int ip[],int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(r-l==0) {
				return mid;
			}
			else if(r-l==1) {
				if(ip[l]<ip[r]) return r;
				else return l;
			}
			else if((ip[mid]>ip[mid-1] && ip[mid]>ip[mid+1] )) return mid;
			else if(ip[mid] > ip[mid+1] && ip[mid] < ip[mid-1]) return findMax(ip, l, mid-1);
			else if(ip[mid] < ip[mid+1]) return findMax(ip,mid+1,r);
		}
		return -1;
	}
	
	static int findXBeforeMax(int ip[],int x,int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(ip[mid]==x) return mid;
			else if(x<ip[mid]) return findXBeforeMax(ip, x, l, mid-1);
			else if(x>ip[mid]) return findXBeforeMax(ip, x, mid+1, r);
		}
		return -1;
	}
	
	static int findXAfterMax(int ip[],int x,int l,int r) {
		int mid = l + (r-l)/2;
		while(l<=r) {
			if(ip[mid]==x) return mid;
			else if(x > ip[mid]) return findXAfterMax(ip, x, l, mid-1);
			else if(x < ip[mid]) return findXAfterMax(ip, x, mid+1, r);
		}
		return -1;
	}*/
}
