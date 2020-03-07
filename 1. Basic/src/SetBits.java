import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-set-bits-in-an-integer/

class SetBits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			
			//one line answer
			System.out.println( Integer.bitCount( Integer.valueOf( br.readLine() )));
			
			//lengthy answer
			/*
			String s = br.readLine();
			String binary = Integer.toString(Integer.parseInt(s), 2);  //one line answer for Decimal to binary
			//String l = Integer.toBinaryString(Integer.parseInt(s));  //one line answer for Decimal to binary
			int count = 0 ;
			for (int i = 0; i < binary.length(); i++) {
				if(binary.charAt(i)=='1') {
					count++;
				}
			}
			System.out.println(count);
			*/
		}
	}
}
