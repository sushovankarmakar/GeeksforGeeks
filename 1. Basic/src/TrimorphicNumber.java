import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TrimorphicNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			long n = Long.parseLong(br.readLine());
			int len = String.valueOf(n).length();
			long cube = n*n*n;
			long result = cube - n;
			boolean b = true;
			
			while(len-->0) {
				long digit = result % 10;
				if(digit==0) {
					result /= 10;
					continue;
				}
				else {
					b = false;
					break;
				}
			}
			System.out.println((b)?"1":"0");
			//System.out.println(cube);
			//System.out.println(digit);
		}
	}
}
