import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindTheHighestNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int posHighest = findHighest(ip,0,n-1);
			System.out.println(ip[posHighest]);
		}
	}
	
	static int findHighest(int ip[],int l,int r) {
		int mid = l + (r-l)/2;
		if(l<=r) {
			if(r-l==0) {
				// if there is only one number present or left
				return mid;
			}
			else if(r-l==1) {
				// if there are two numbers present or left
				if(ip[mid]<ip[mid+1]) 
					return mid+1;
				else 
					return mid;
			}
			else if(ip[mid]>ip[mid+1] && ip[mid]>ip[mid-1]) {
				//highest number is that number whose both side value is less than itself.
				return mid;
			}
			else if(ip[mid]>ip[mid-1]) {
				/* if mid value is greater than it's previous value
				 * then highest value will be present in the right side */

				return findHighest(ip,mid+1,r);
			}
			else if( (ip[mid]<ip[mid+1]) || (ip[mid]<ip[mid-1] && ip[mid]>ip[mid+1]) ) {
				/*1. if mid value is less than it's next value then highest value will be present in the left side
				 *2. if mid value is less than it's previous value and greater than it's next value 
				 *	 then highest value will be present in the right side. example. 4 9 3 2 1
				*/
				
				return findHighest(ip,l,mid-1);
			}
		}
		return -1;
	}
}
