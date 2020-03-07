import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SumOfSubstrings_of_number {
 
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			int n = Integer.parseInt(br.readLine());
			System.out.println(sumOfSubString(n));
			
			/*String n = br.readLine().trim();
			int l = String.valueOf(n).length();*/
			
			/*int sum = 0,d =0;   //process 1
			
			for (int i = 0; i < l; i++) {
				for (int j = i+1; j <= l; j++) {
					d = Integer.parseInt(n.substring(i, j));
					sum += d;	
				}
			}
			System.out.println(sum);*/
			
			//System.out.println(sumOfSubStrings(n,l));
		}		
	}

	/*static int sumOfSubStrings(String n,int l) {  //process 2
		
		int sumOfDigit[] = new int[l];
		sumOfDigit[0] = n.charAt(0)-'0';
		int sum = sumOfDigit[0];
		for (int i = 1; i < l; i++) {
			int numi = n.charAt(i)-'0';
			
			sumOfDigit[i] = numi*(i+1) + 10*(sumOfDigit[i-1]);
			
			sum += sumOfDigit[i];
		}
		return sum;
	}*/
	
	//process 3
	
	static long sumOfSubString(int n) {
		
		String s = String.valueOf(n);
		long totalSum =0;
		long mf = 1;
		
		for (int i = s.length()-1; i >= 0 ; i--) {
			long sum = ((s.charAt(i)-'0')*(i+1)*mf)%mod;
			
			mf = mf*10 + 1;
			
			totalSum += sum; 
		}
		
		return (totalSum % mod);
	}
	
}
