import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Product_of_max_first_arr_and_min_in_sec {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			int n1 = Integer.parseInt(br.readLine());
			int ip1[] = new int[n1];
			String s1[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < s1.length; i++) {
				ip1[i] = Integer.parseInt(s1[i]);
				if(max < ip1[i]) max = ip1[i]; 
			}
			
			int n2 = Integer.parseInt(br.readLine());
			int ip2[] = new int[n2];
			String s2[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < s2.length; i++) {
				ip2[i] = Integer.parseInt(s2[i]);
				if(min > ip2[i]) min = ip2[i];
			}
			long result = max*min;
			System.out.println(result);
		}
	}
}
