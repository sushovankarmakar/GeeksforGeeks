import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BinarySearch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int k = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(binarySearch(ip,0,n-1,k));
		}
	}
	
	static int binarySearch(int ip[],int left,int right,int k) {
		
		while(left<=right) {
			int mid = left + (right-left)/2;
			if(k==ip[mid]) {
				return mid;
			}
			else if(k < ip[mid]) {
				right = mid-1;
			}
			else if(ip[mid] < k) {
				left = mid+1;
			}
		}
		return -1;
	}
}
