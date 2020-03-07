import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SearchInRotatedArray {

	public static void main(String[] args) throws IOException {
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
	}
}
