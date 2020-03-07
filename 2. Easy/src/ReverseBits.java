import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ReverseBits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			String l = Long.toBinaryString(Long.parseLong(br.readLine())); //converting the given input into binary form
			String op = String.format("%32s", l).replace(' ', '0');       //padding required zeros ahead of the 32 bit representation
		
			StringBuffer sb = new StringBuffer(op);    
			String s = new String(sb.reverse());           // reversing the string
			
			long a = Long.parseLong(s,2);                 // getting the decimal value of the reversed string
			System.out.println(a);
		}
	}
}
