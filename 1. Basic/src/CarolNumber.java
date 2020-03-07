import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CarolNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n==1) {
				System.out.println("1");
			}
			else {
				String a = "";
				for (int i = 0; i < n-2; i++) {
					a +=  "1";
				}
				a += "0";
				for (int i = 0; i < n+1; i++) {
					a +=  "1";
				}
				
				System.out.println(binaryToDecimal(a));
			}
		}
	}
	
	static long binaryToDecimal(String s) {
		long no = 0;
		int n=0;
		for (int i = s.length()-1; i >=0 ; i--) {
			if(s.charAt(i)=='1') {
				long a = (long)Math.pow(2, n);
				no += a;
			}
			n++;
		}
		return no;
	}
}
