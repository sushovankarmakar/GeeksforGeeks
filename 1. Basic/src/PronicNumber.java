import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PronicNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int r = Integer.parseInt(br.readLine());
			int n1=0,n2=1;
			int op = n1* n2;
			while(op<=r) {
				System.out.print(op+" ");
				n1 = n2;
				n2++;
				op = n1*n2;
			}
			System.out.println();
		}
	}
}
