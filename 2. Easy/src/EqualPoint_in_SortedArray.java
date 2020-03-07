import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class EqualPoint_in_SortedArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int d=ip[0],d_no=1;
			
			for (int i = 1; i < n; i++) {
				if(ip[i]!=d) {
					d_no++;
					d = ip[i];
				}
			}
			
			if(d_no==1) {
				System.out.println("0");
			}
			else if(d_no%2!=0) {
				int a = d_no/2;
				//System.out.println(a);
				d=ip[0];
				d_no=0;
				
				for (int i = 1; i < n; i++) {
					if(ip[i]!=d) {
						d_no++;
						d = ip[i];
						//System.out.println(d_no);
						if(d_no==a) {
							System.out.println(i);
							break;
						}
					}
				}
			}
			else {
				System.out.println("-1");
			}
		}
	}
}
