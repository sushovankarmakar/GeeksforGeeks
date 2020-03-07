import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class MaxIntegerValue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			
			/*long ans = Character.getNumericValue(s.charAt(0));
			
			for (int i = 1; i < s.length(); i++) {
				long temp1 = ans+ Character.getNumericValue(s.charAt(i)), temp2 = ans* Character.getNumericValue(s.charAt(i));
				
				if(temp1 > temp2) ans = temp1;
				else ans = temp2;
			}
			System.out.println(ans);*/
			
			BigInteger ans = BigInteger.valueOf(Character.getNumericValue(s.charAt(0)));
			
			for (int i = 1; i < s.length(); i++) {
				BigInteger temp1 = ans.add(BigInteger.valueOf(Character.getNumericValue(s.charAt(i)))); 
				BigInteger temp2 = ans.multiply(BigInteger.valueOf(Character.getNumericValue(s.charAt(i))));
				
				ans = temp1.max(temp2);
			}
			System.out.println(ans);
		}
	}
}
