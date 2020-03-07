import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/write-your-own-atoi/

class ImplementAtoi {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			System.out.println(atoi(ip));
		}
	}
	
	static int atoi(String ip) {
		char charsOfip[] = ip.toCharArray();
		
		for(int i = 0; i< charsOfip.length; i++) {
			if(charsOfip[i]=='-') continue;
			if(!Character.isDigit(charsOfip[i])) return -1;
		}
		return Integer.parseInt(ip);
	}
}
