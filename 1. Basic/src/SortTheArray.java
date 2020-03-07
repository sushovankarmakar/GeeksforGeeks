import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;


class SortTheArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine());
			int a[] = new int[size]; 
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < size; i++) {
				a[i] = Integer.parseInt(s[i]);
 			}
			//Arrays.sort(a);
			//System.out.println(Arrays.toString(a).replace("[","").replace("]", "").replace(",", ""));
			quickSort(a,0,s.length-1);
			for (int i = 0; i < s.length; i++) {
				sb.append(a[i]+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	
	static void quickSort(int a[],int low, int high) {
		if(low < high) {
			int pivot = partition(a,low,high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
	}
	
	static int partition(int a[],int low, int high) {
		int pivot = a[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(a[j] <= pivot) {
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
