import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class JugglerSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.print(n+" ");
			while(n!=1) {
				if(n%2==0) {
					n = juggle(n,0.5);
					System.out.print(n+" ");
				}
				else {
					n = juggle(n,1.5);
					System.out.print(n+" ");
				}
			}
			System.out.println();
		}
	}
	
	static int juggle(int a,double base) {
		a = (int) Math.pow(a, base);
		return a;
	}
}
