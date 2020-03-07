import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Min_num_to_form_sum_even {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine());
			int sum = 0;
			String[] ip = br.readLine().trim().split("\\s+");
			for (int i = 0; i < size; i++) {
				sum += Integer.parseInt(ip[i]);
			}
			System.out.println((sum%2==0)?"2":"1");
		}
	}
}
