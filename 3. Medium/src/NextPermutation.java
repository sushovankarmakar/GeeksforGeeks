import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/

class NextPermutation {

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
			
			int i;
			for(i = n-1 ; i > 0; i--) {
				if(arr[i-1] < arr[i]) break;
			}
			
			if(i > 0 ) {
				int num = arr[i-1], nextGreaterNumPos = i;
				
				for(int j = i+1; j < n; j++) {
					if(num < arr[j]  && arr[j] < arr[nextGreaterNumPos]) {
						nextGreaterNumPos = j;
					}
				}
				swap(arr, i-1, nextGreaterNumPos);
			}
			
			reverse(arr,i,n-1);
			
			// this reverse process wasn't working in leetcode so, I used Arrays.sort(arr,i,n);
			
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
	
	static void reverse(int arr[], int left, int right) {
		while(left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}
	
	static void swap(int ip[], int i, int j) {
		int temp = ip[i];
		ip[i] = ip[j];
		ip[j] = temp;
	}
}
