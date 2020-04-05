import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x/0

public class CountTripletsWithSumSmallerThanX {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String NX[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(NX[0]);
			int x = Integer.parseInt(NX[1]);
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(countTripletsWithSumSmallerThanX(ip, n, x));
		}
	}
	
	private static int countTripletsWithSumSmallerThanX(int ip[], int n, int x) {
		int count = 0;
		
		quickSort(ip, 0, n-1);
		
		for (int i = 0; i < n-2; i++) {
			int l = i+1;
			int r = n-1;
			while( l < r ) {
				int tripletSum = ip[i] + ip[l] + ip[r];
				
				if(tripletSum < x) {
					//This is important. For current i and j, there can be total (r-l) third elements.
					count += (r-l);
					l++;
				}
				if(tripletSum >= x ) {
					r--;
				}
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
		int i = low-1;
		int pivot = ip[high];
		for (int j = low; j < high; j++) {
			if(ip[j] <= pivot) {
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
















