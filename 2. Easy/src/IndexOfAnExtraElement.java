import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-index-of-an-extra-element-present-in-one-sorted-array/

class IndexOfAnExtraElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int ip1[] = new int[n], ip2[] = new int[n-1]; 
			for (int i = 0; i < n; i++) {
				ip1[i] = Integer.parseInt(s1[i]);
				
				if(i < (n-1)) {
					ip2[i] = Integer.parseInt(s2[i]);
				}
				
				// algorithm -1
				
				/*if(ip1[i]!=ip2[i]) {
					System.out.println(i);
					break;
				}*/
			}
			
			// algorithm -2
			int len = ip2.length;
			System.out.println(binarySearch(ip1,ip2,len));
		}
	}
	
	public static int binarySearch(int ip1[], int ip2[], int n) {
		int index = n;
		int left = 0, right = n-1;
		while(left <= right) {
			
			int mid = left + (right-left)/2;
			
			if(ip1[mid]==ip2[mid]) {
				left = mid+1;
			}
			else {
				index = mid;
				right = mid-1;
			}
		}
		return index;
	}
}




