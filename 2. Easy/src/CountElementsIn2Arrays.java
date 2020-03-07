import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CountElementsIn2Arrays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine().trim());
		
		// algorithm-2, time taken: 0.29
		
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(s[0]), n2 = Integer.parseInt(s[1]);
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			
			int arr1[] = new int[n1], arr2[] = new int[n2];
			for (int i = 0; i < n1; i++) {
				arr1[i] = Integer.parseInt(s1[i]);
			}
			for (int i = 0; i < n2; i++) {
				arr2[i] = Integer.parseInt(s2[i]);
			}
			
			// sorting the 2nd array
			quickSort(arr2,0, n2-1);
			
			// apply binary search on 2nd array for each value of 1st array 
			for (int i = 0; i < n1; i++) {
				int val = arr1[i];
				int pos = binarySearch(arr2,val,0,n2-1);
				sb.append(pos+1+" ");
			}
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
	
	static int binarySearch(int arr[],int val,int left,int right) {

		while(left <= right) {
			int mid = left + (right-left)/2;
			if(arr[mid] <= val) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return right;
	}
	
	static void quickSort(int a[],int low,int high) {
		if(low < high) {
			int pivot = partition(a,low,high);
			quickSort(a,low,pivot-1);
			quickSort(a,pivot+1,high);
		}
	}
	
	static int partition(int a[], int low, int high) {
		int val = a[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(a[j] <= val) {
				i++;
				swap(a,i,j);
			}
		}
		swap(a,i+1,high);
		return i+1;
	}
	
	static void swap(int a[],int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

// algorithm 1, time taken: 0.21

//O(n) solution but takes extra memory

		/*while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(s[0]), n2 = Integer.parseInt(s[1]);
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			
			int arr1[] = new int[n1], arr2[] = new int[n2];
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n1; i++) {
				arr1[i] = Integer.parseInt(s1[i]);
				
				if(max <= arr1[i]) max = arr1[i];  // finding the maximum value of arr1
			}
			
			System.out.println(max);
			
			int freq[] = new int[max+1];
			for (int i = 0; i < n2; i++) {
				arr2[i] = Integer.parseInt(s2[i]);
				
				if(arr2[i] <= max) freq[arr2[i]]++;
			}
			
			for (int i = 1; i <= max; i++) {
				freq[i] += freq[i-1];
			}
			
			for (int i = 0; i < n1; i++) {
				sb.append(freq[arr1[i]]+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}*/
