import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Product_of_arr_elements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			String ip[] = br.readLine().trim().split("\\s+");
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			long mod = 1000000007L;
			System.out.println(product(arr,mod,n));
		}
	}
	
	public static Long product(long arr[], Long mod, int n) {
		
		long ans= 1L; 
		for (int i = 0; i < n; i++) {
			ans = (ans * arr[i])%mod; 
		}
		return  ans;
	}
}
