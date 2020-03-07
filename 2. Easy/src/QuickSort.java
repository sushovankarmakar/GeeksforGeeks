import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class QuickSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			quickSort(ip,0,n-1);
			for (int i = 0; i < n; i++) {
				sb.append(ip[i]+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	static void quickSort(int a[],int low,int high) {
		if(low<high) {
			int mid = partition(a,low,high);
			quickSort(a,low,mid-1);
			quickSort(a,mid+1,high);
		}
	}
	static int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(a[j]<=pivot) {
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
