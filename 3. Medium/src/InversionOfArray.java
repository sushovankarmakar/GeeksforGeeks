import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/merge-sort/
//https://www.geeksforgeeks.org/counting-inversions/

class InversionOfArray {

	static long inverseCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			mergeSort(ip,0,n-1);
			for (int i = 0; i < n; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();
			System.out.println(inverseCount);
			inverseCount = 0;
		}
	}
	
	static void mergeSort(int ip[],int l,int r) {
		if(l<r) {
			int mid = l + (r-l)/2;
			mergeSort(ip,l,mid);
			mergeSort(ip,mid+1,r);
			merge(ip,l,mid,r);
		}
	}
	
	static void merge(int ip[],int l,int mid,int r) {
		int range1 = mid - l + 1, range2 = r - mid;
		int left[] = new int[range1] , right[] = new int[range2];
		for (int i = 0; i < range1; i++) {
			left[i] = ip[l+i];
		}
		for (int i = 0; i < range2; i++) {
			right[i] = ip[mid+1+i];
		}
		
		int i = 0, j = 0, k = l;
		while( i < range1 && j < range2 ) {
			if(left[i] <= right[j]) {
				ip[k] = left[i];
				i++;
			}
			else {
				ip[k] = right[j];
				j++;
				inverseCount += (range1-i);
			}
			k++;
		}
		
		while( i < range1) {
			ip[k] = left[i];
			k++;
			i++;
		}
		
		while( j < range2) {
			ip[k] = right[j];
			k++;
			j++;
		}
	}
}
