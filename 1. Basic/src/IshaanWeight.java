import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class IshaanWeight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), k = Integer.parseInt(ip[1]);
			long totalMoney = 0;
			
			for (int i = 0; i <= n; i+=k ) {
				totalMoney += i;
			}
			System.out.println(totalMoney);
		}
	}
}
