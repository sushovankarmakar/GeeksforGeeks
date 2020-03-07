import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Second_largest_element {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine());
			String[] ip = br.readLine().trim().split("\\s+");
			
			int sm = -1;
			int m = Integer.parseInt(ip[0]);
			for (int i = 1; i < size; i++) {
				
				if(m < Integer.parseInt(ip[i])) {
					sm = m;
					m = Integer.parseInt(ip[i]);
				}
				else if(m==Integer.parseInt(ip[i])){
					
				}
				else if(sm < Integer.parseInt(ip[i])) {
					sm = Integer.parseInt(ip[i]);
				}
			}
			System.out.println(sm);
		}
	}
}
