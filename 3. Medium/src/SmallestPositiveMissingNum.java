import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
// https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

class SmallestPositiveMissingNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}
			
			// partition contains the position where -ve and +ve numbers get divided.
			int partition = seperate(arr,n);
			
			// posNumsOnly[] contains only the positive numbers which were in the input array
			int posNumsOnly[] = new int[n-partition]; 
		    int j=0; 
		    for(int i=partition;i<n;i++) 
		    { 
		    	posNumsOnly[j] = arr[i]; 
		        j++; 
		    }
			
			// to mark a number's presence, we make it -ve
		    for(int i = 0; i < posNumsOnly.length; i++) 
		    { 
		       int x = Math.abs(posNumsOnly[i]); 
		       if(x - 1 < posNumsOnly.length && posNumsOnly[x - 1] > 0) 
		    	   posNumsOnly[x - 1] = -posNumsOnly[x - 1]; 
		    }
			
		    
		    // printing the first non-negative number as it is the first missing number in the array
		    // i+1 because index starts from 0, but 0 is not non-negative
			for (int i = 0; i < posNumsOnly.length; i++) {
				if(posNumsOnly[i] > 0)	{
					System.out.print( (i+1) +" ");
					break;
				}
			}
		}
	}
	
	static void swap(int i,int j,int arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int seperate(int arr[],int n) {
		int pos = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <=0) {
				swap(i,pos,arr);
				pos++;
			}
		}
		return pos;
	}
}






















// this solution gives time limit exceeds
/*
int maxValue = Integer.MIN_VALUE;
for (int i = 0; i < ip.length; i++) {
	int no = Integer.parseInt(ip[i]);
	if(maxValue < no) {
		maxValue = no;
	}
}
if(maxValue <= 0) {
	System.out.println("1");
}
else {
	int op[] = new int[maxValue+2];
	for (int i = 0; i < ip.length; i++) {
		int no = Integer.parseInt(ip[i]);
		if(no > 0) {
			op[no] = 1;
		}
	}
	
	for (int i = 1; i < op.length; i++) {
		if(op[i]==0) {
			System.out.println(i);
			break;
		}
	}
}
*/

