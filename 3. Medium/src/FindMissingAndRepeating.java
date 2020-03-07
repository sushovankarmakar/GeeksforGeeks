import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-the-repeating-and-the-missing-number-using-two-equations/
// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

// submitted this below solution : create a frequency array of size n and if array element is 0, then it is missing and element is >1
// then it is the repeated element.
// https://ide.geeksforgeeks.org/sMXXKQlCUc

class FindMissingAndRepeating {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] ip = br.readLine().trim().split("\\s+");
			int[] arr = new int[n];
			
			for(int i= 0; i< n; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}
			int xor = 0; 
			
			for(int i= 0; i< n; i++) {
				xor ^= arr[i];
			}
			
			for(int i= 1; i<= n; i++) {
				xor ^= i;
			}
			
			int setBitNum = xor & ~(xor-1);
			
			int x = 0, y = 0;
			for(int i=0; i<n; i++) {
				if((arr[i] & setBitNum) != 0) 
					x ^= arr[i];
				else 
					y ^= arr[i];
			}
			
			for(int i=1; i<=n; i++) {
				if((i & setBitNum) != 0)
					x ^= i;
				else
					y ^= i;
			}
			
			int missingNum = 0,repeatedNum = 0; 
			for(int i=0; i<n ; i++) {
				if(arr[i] == x) {
					repeatedNum = x; missingNum = y; 
				}
				else if(arr[i] == y) {
					repeatedNum = y; missingNum = x; 
				}
			}
			System.out.println(repeatedNum+" "+missingNum);
		}
	}
}


			//Approach - 1 : using two equations
			// will take much more time
			
			/*int sumOfArr = 0, sumOfN = n*(n+1)/2 , sumOfArrSq = 0 , sumOfNSq = (n*(n+1)*( 2*n + 1))/6;
			
			
			for(int i=0; i< n; i++) {
				arr[i] = Integer.parseInt(ip[i]);
				sumOfArr += arr[i];
				sumOfArrSq += (arr[i]*arr[i]);
			}
			
			int missingNum = ((sumOfN-sumOfArr)  + ( sumOfNSq-sumOfArrSq )/(sumOfN-sumOfArr)) /2 ;
			int repeatedNum = missingNum - (sumOfN - sumOfArr);
			
			System.out.println(repeatedNum+" "+missingNum);*/