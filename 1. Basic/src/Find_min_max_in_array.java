import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Find_min_max_in_array {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int l = Integer.parseInt(br.readLine());
			String ip[] = br.readLine().trim().split("\\s+");
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < l; i++) {
				if(min > Integer.parseInt(ip[i])) min = Integer.parseInt(ip[i]);
				if (max < Integer.parseInt(ip[i])) max = Integer.parseInt(ip[i]);
			}
			System.out.println(min+" "+max);
		}
	}
}
