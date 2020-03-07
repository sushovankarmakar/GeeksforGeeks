import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/

//using binary search
class NumberOfOccurrence {

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
}



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
