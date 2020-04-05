import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
// https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1/

public class FindTripletsWithZeroSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(getTripletWithZeroSum(ip, n));
		}
	}
	
	private static boolean getTripletWithZeroSum(int ip[], int n) {
		
		quickSort(ip, 0, n-1);
		
		for(int i=0; i < n -2; i++) {
			int l = i+1;
			int r = n-1;
			int tripletSum = 0;
			while(l<r) {
				tripletSum = ip[i] + ip[l] + ip[r];
				
				if(tripletSum == 0) return true; 
				if(tripletSum < 0) l++;
				if(tripletSum > 0) r--;
			}
		}
		return false;
	}
	
	
	private static void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int pos = partition(arr, low, high);
			quickSort(arr, low, pos-1);
			quickSort(arr, pos+1, high);
		}
	}
	
	private static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low -1;
		
		for(int j= low; j < high; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	
	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
