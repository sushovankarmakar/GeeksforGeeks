import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SmallestGreaterElementsInWholeArr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			int max = Integer.MIN_VALUE;
			int op[] = new int[n];
			for (int i = 0; i < n; i++) {
				int a = ip[i];
				
				if(a >= max) max = a;
				
				int b=0;
				int diff=Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if(i!=j) {
						if(a < ip[j]) {
							int d = ip[j] - a;
							//System.out.print("d ="+d);
							//System.out.println();
							if(diff > d) {
								diff = d;
								b = ip[j];
								//System.out.print(b+"\n");
							}
						}
					}
				}
				op[i] = b;
			}
			
			//System.out.println(max);
			
			for (int i = 0; i < n; i++) {
				if(ip[i]==max && op[i]==0) System.out.print("_ ");
				else System.out.print(op[i]+" ");
			}
			System.out.println();
		}
	}
}
