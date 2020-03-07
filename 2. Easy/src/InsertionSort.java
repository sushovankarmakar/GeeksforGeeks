import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {

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
			insertionSort(ip);
			for (int i = 0; i < n; i++) {
				sb.append(ip[i]+" ");
			}
			System.out.println(sb);
		}
	}
	
	static void insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			insert(a,i);
		}
	}
	
	static void insert(int a[],int pos) {
		int val = a[pos];
		int i = pos-1;
		while(i >=0 && a[i] > val ) {
			a[i+1] = a[i];
			i--;
		}
		a[i+1] = val;
	}
}
