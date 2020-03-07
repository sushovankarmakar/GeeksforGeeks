import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/position-of-rightmost-set-bit/

class FindFirstSetBit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			
			/*
			// aprroach -1 
			if(n==0) {
				if the number is 0, then this is the only special case when no set bit will be presented,
				so no need to convert to binary and find the position of set bits
				System.out.println("0"); 
			}
			else {
				String binary = Integer.toBinaryString(n);
				for (int i = binary.length()-1; i >=0 ; i--) {
					if(binary.charAt(i)=='1') {
						System.out.println(binary.length()-i);
						break;
					}
				}
			}*/
			
			System.out.println((int)(Math.log10(n & -n)/Math.log10(2)+1));
		}
	}
}
