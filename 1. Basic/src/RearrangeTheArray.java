import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class RearrangeTheArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int len = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int in[] = new int[len];
			for (int i = 0; i < in.length; i++) {
				in[i] = Integer.parseInt(s[i]);
			}
			
			Arrays.sort(in);
			int op[] = new int[in.length];
			
			int a=0;
			for (int i = 0, j= len-1; i <= j; i++, j--) {
				
				if(a< op.length) {
	                op[a] = in[i];
	                a++;
	            }
				if(a< op.length) {
	                op[a] = in[j];
	                a++;
	            }
	            
			}
			
			for (int i = 0; i < op.length; i++) {
				System.out.print(op[i]+" ");
			}
			System.out.println();
		}
	}
}
