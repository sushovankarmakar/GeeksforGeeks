import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class WhoWillWin {

	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), m = Integer.parseInt(ip[1]), 
				g = Integer.parseInt(ip[2]), s = Integer.parseInt(ip[3]);
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i+1;
			}

			bSearch(arr,0,arr.length-1,m);
			int timeG = g*m;
			int timeS = s*count;
			
			if(timeG < timeS) System.out.println("1"); // Gautam wins
			else if(timeG > timeS) System.out.println("2"); // Subhash wins
			else if(timeG == timeS) System.out.println("0"); // Draw
			count=0;
		}
	}
	
	static int bSearch(int arr[],int l,int r,int m) {
		
		if(l<=r) {
			int mid = l+(r-l)/2;
			if(arr[mid]==m) {
				count++;
				return mid;
			}
			if(arr[mid] < m) {
				count++;
				bSearch(arr,mid+1,r,m);
			}
			else if(arr[mid] > m ) {
				count++;
				bSearch(arr,l,mid-1,m);
			}
		}
		return -1;
	}
}
