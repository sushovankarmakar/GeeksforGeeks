import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class SortInSpecificOrder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb1 = new StringBuffer(),sb2 = new StringBuffer();
			long ip[] = new long[n];
			int oddNo=0;
			for (int i = 0; i < n; i++) {
				ip[i] = Long.parseLong(s[i]);
				if(ip[i]%2!=0) oddNo++;
			}
			Long odd[] = new Long[oddNo]; 
			long even[] = new long[n-oddNo];
			int i=0,j=0;
			for (int k = 0; k < n; k++) {
				if(ip[k]%2!=0)  odd[i++] = ip[k];
				else 			even[j++] = ip[k];
			}
			Arrays.sort(odd, Collections.reverseOrder());
			Arrays.sort(even);
			for (int pos = 0; pos < odd.length; pos++) {
				sb1.append(odd[pos]+" ");
			}
			System.out.print(sb1);
			for (int pos = 0; pos < even.length; pos++) {
				sb2.append(even[pos]+" ");
			}
			System.out.println(sb2);
		}
	}
}






/*import java.util.Arrays; 
import java.util.Collections; 

class SortInSpecificOrder 
{ 
	 
	static void twoWaySort(Integer arr[], int n) 
	{ 
		int l = 0, r = n-1; 
	
		int k = 0; 
	
		while (l < r) 
		{ 
			// Find first odd number from left side.
			while (arr[l]%2 != 0) 
			{ 
				System.out.println("Left :"+ arr[l]);
				l++;
				k++;
				System.out.println("k :"+k);
			}
			
			// Find first even number from right side.
			System.out.println("Right :"+ arr[r]);
			while (arr[r]%2 == 0 && l<r) 
				r--; 
	
			// Swap odd number present on left and even 
			// number right. 
			if (l < r) 
			{  
				int temp = arr[l]; 
				arr[l] = arr[r]; 
				arr[r] = temp; 	
			}
			
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			//System.out.println(Arrays.toString(arr));
				
		} 
		System.out.print("k = "+ k);
		System.out.println();
		// Sort odd number in descending order 
		Arrays.sort(arr, 0, k,Collections.reverseOrder()); 
	
		// Sort even number in ascending order 
		Arrays.sort(arr, k, n); 
	} 
	
	// Driver Method 
	public static void main(String[] args) 
	{ 
		Integer arr[] = {1, 2, 3, 5, 4, 7, 10}; 
		
		twoWaySort(arr, arr.length); 
		
		System.out.println(Arrays.toString(arr)); 
	} 
} 
*/