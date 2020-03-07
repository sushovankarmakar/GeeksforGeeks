import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://ide.geeksforgeeks.org/IoewgLSUJ1
// https://practice.geeksforgeeks.org/editorial.php?pid=2087
// https://practice.geeksforgeeks.org/viewSol.php?subId=8774348&pid=2087&user=HimanshuSingh16

class CountTheElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip1[] = br.readLine().trim().split("\\s+"), ip2[] = br.readLine().trim().split("\\s+");
			int a[] = new int[n], b[] = new int[n];
			
			// O(n) solution
			int maxA = Integer.MIN_VALUE; 
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(ip1[i]);
				if(maxA < a[i]) maxA = a[i];  // finding the maximum value of array A 
			}
			
			// in first step, freqOfB stores frequency of every value of array B, whose value ranging from 0 to maxA 
			int freqOfB[] = new int[maxA+1];
			for (int i = 0; i < n; i++) {
				b[i] = Integer.parseInt(ip2[i]);
				
				if(b[i] <= maxA) freqOfB[b[i]]++;
			}
			
			// here we're doing cumulative sum
			// logic : if 5 is less than 3, then 5 is also less than 2,1,0
			for (int i = 1; i <= maxA; i++) {
				freqOfB[i] += freqOfB[i-1] ; 
			}
			
			int q = Integer.parseInt(br.readLine().trim());
			while(q-->0) {
				int index = Integer.parseInt(br.readLine().trim()), no = a[index];
				
				System.out.println(freqOfB[no]);
			}
			
			
			// O(n^2) solution
			
			/*
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(ip1[i]);
				b[i] = Integer.parseInt(ip2[i]);
			}
			
			int q = Integer.parseInt(br.readLine().trim());
			while(q-->0) {
				int index =  Integer.parseInt(br.readLine().trim()), no = a[index] , count = 0;
				for (int i = 0; i < n; i++) {
					if(b[i] <= no) count++;
				}
				System.out.println(count);
			}*/
		}
	}
}
