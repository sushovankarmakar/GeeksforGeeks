import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/count-the-triplets/0/
// https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/

public class CountTheTriplets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int count = countNumberOfTriplets(ip, n);
			System.out.println(count == 0 ? "-1": count);
		}
	}
	
	private static int countNumberOfTriplets(int ip[], int n) {
		int count = 0;
		
		quickSort(ip, 0, n-1);
		
		for (int i = n-1; i > 1 ; i--) {
			int l = 0;
			int r = i-1;
			while( l < r ) {
				int sum = ip[l] + ip[r];
				
				if( sum == ip[i] ) {
					count++;
					l++;
					r--;
				}
				else if( sum < ip[i] )	l++;
				else if( sum > ip[i] )	r--;
			}
		}
		return count;
	}
	
	private static void quickSort(int ip[], int low, int high) {
		if(low < high) {
			int pos = partition(ip, low, high);
			quickSort(ip, low, pos-1);
			quickSort(ip, pos+1, high);
		}
	}
	
	private static int partition(int ip[], int low, int high) {
		int i = low -1;
		int pivot = ip[high];
		for(int j = low; j < high; j++) {
			if(ip[j]<=pivot) {
				i++;
				swap(ip,i,j);
			}
		}
		swap(ip, i+1, high);
		return i+1;
	}
	
	private static void swap(int ip[], int i, int j) {
		int temp = ip[i];
		ip[i] = ip[j];
		ip[j] = temp;
	}	
}


