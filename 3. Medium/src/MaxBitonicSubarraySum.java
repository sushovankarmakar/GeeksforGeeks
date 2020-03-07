import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaxBitonicSubarraySum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			
			// msis = max sum increasing sub array , msds = max sum decreasing sub array
			
			int ip[] = new int[n]; 
			long msis[] = new long[n], msds[] = new long[n];  
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				msis[i] = msds[i] = ip[i];
			}
			
			for (int i = 1; i < n; i++) {
				if(ip[i-1] < ip[i]) {
					msis[i] += msis[i-1];
				}
			}
			
			for (int i = n-2; i >=0 ; i--) {
				if(ip[i] > ip[i+1]) {
					msds[i] += msds[i+1];
				}
			}
		
			Long maxBitonicSubSum = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				long val = msis[i] + msds[i] - ip[i];
				if(maxBitonicSubSum < val) maxBitonicSubSum = val;
			}
			System.out.println(maxBitonicSubSum);
		}
	}
}


// algorithm giving time limit exceed

/*for (int i = 1; i < n; i++) {
	int val = ip[i], val1 = ip[i];
	
	for (int j = i-1; j >=0 ; j--) {
		
		if(ip[j] < val1) {
			lis[i] = Math.max(lis[i], lis[j]+val);
			val1 = ip[j];
		}
		else break;
	}
}

for (int i = n-2; i >=0 ; i--) {
	int val = ip[i], val1 = ip[i];
	
	for (int j = i+1; j < n ; j++) {
		
		if(ip[j] < val1) {
			lds[i] = Math.max(lds[i], lds[j]+val);
			val1 = ip[j];
		}
		else break;
	}
}*/