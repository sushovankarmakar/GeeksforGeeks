import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// https://www.geeksforgeeks.org/position-rightmost-different-bit/

class RightmostDiffBit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(ip[0]), n2 = Integer.parseInt(ip[1]);
			
			/*
			// aprroach-1
			//formatting the integer input into 0-padded binary representation
			String s1 = String.format("%32s", Integer.toBinaryString(n1)).replace(" ", "0"), 
				   s2 = String.format("%32s", Integer.toBinaryString(n2)).replace(" ", "0");
			
			int pos = -1;
			for (int i = 31; i >=0 ; i--) {
				if(s1.charAt(i)!=s2.charAt(i)) {
					pos = 32-i;
					break;
				}
			}
			System.out.println(pos);*/
			int ans = n1^n2;
			System.out.println((int)(Math.log10(ans & -ans)/Math.log10(2))+1);
		}
	}
}
