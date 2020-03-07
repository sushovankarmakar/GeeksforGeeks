import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
class KthSmallest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine());
			int a[] = new int[size];
			String s[] = br.readLine().trim().split("\\s+");
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(a);
			System.out.println(a[k-1]);
		}
	}
}
