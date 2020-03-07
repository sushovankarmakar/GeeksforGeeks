import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/

class MaxOfMinForEveryWindowSize {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			int windowSize=1;
			for (int i = 0; i <n; i++) {
				int maxOfMin = Integer.MIN_VALUE;
				
				for (int j = windowSize-i-1; j <= (n-windowSize); j++ ) {
					
					int min = minValue(ip,j,(j+windowSize-1));
					
					if(maxOfMin < min) maxOfMin = min;
				}
				windowSize++;
				sb.append(maxOfMin+" ");
			}
			System.out.println(sb);
		}
	}
	
	static int minValue(int ip[],int i,int j) {
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			if(ip[k] < min) min = ip[k];
		}
		return min;
	}
}
