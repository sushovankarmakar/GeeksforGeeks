import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindTheClosestNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]), diff = Integer.MAX_VALUE, op = 0;
			String s2[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s2[i]);
				int d = Math.abs(k-ip[i]); 
				if(d <= diff) {
					op = ip[i];
					diff = d;
				}
				
				if(k<ip[i]) break;
			}
			System.out.println(op);
		}
	}

}
