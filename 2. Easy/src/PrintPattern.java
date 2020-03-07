import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PrintPattern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.print(n+" ");
			
			// condition was not to use any loop, so I used recursion.
			check(n-5);
			System.out.println();
		}
	}
	
	static void check(int n) {
		
		System.out.print(n+" ");
		if(n>0) {
			check(n-5);
		}
		System.out.print((n+5)+" ");
		return;
	}
}
