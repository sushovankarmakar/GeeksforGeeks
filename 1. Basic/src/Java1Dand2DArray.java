import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Java1Dand2DArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), max = Integer.MIN_VALUE ,sum =0, leap=0;;
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int arr2D[] = new int[n*n], arr1D[] = new int[n];
		
			for (int i = 0; i < arr2D.length; i++) {
				arr2D[i] = Integer.parseInt(s1[i]);
				
				//sum of the diagonal values of the 2-d array
				if(i==leap) {
					sum += arr2D[i];
					leap += (n+1);
				}
			}
			for (int i = 0; i < arr1D.length; i++) {
				arr1D[i] = Integer.parseInt(s2[i]);
				if(max < arr1D[i]) max = arr1D[i];
			}
			System.out.println(sum+" "+max);
		}
	}
}
