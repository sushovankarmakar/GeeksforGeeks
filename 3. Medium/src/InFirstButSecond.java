import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InFirstButSecond {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String NM[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(NM[0]);
			int m = Integer.parseInt(NM[1]);
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			String ip1[] = br.readLine().trim().split("\\s+");
			String ip2[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(ip1[i]);
			}
			for (int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(ip2[i]);
			}
			findNumbersInFirstArrayButNotInSecondArray(arr1, arr2, n, m);
		}
	}
	
	private static void findNumbersInFirstArrayButNotInSecondArray(int arr1[], int arr2[], int n, int m) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i = 0, j = 0;
		StringBuilder op = new StringBuilder();
		
		while( i < n && j < m ) {
			
			if( arr1[i] == arr2[j] ) {
				i++;
				j++;
			}
			
			if( arr1[i] > arr2[j] ) {
				j++;
			}
			
			if( arr1[i] < arr2[j] ) {
				//op.append(arr1[i]+" ");
				System.out.print(arr1[i]+" ");
				i++;
			}
		}
		
		while(i < m) {
			op.append(arr1[i]+" ");
			System.out.println(arr1[i]+" ");
			i++;
		}
		
		System.out.println(op);
	}
}















