import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/

class RomanNumToInteger {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			int op = 0;
			for (int i = 0; i < ip.length(); i++) {
				if(ip.charAt(i)=='I') {
					if(i+1 < ip.length() && ip.charAt(i+1)=='V') {
						op += 4;
						i++;
					}
					else if(i+1 < ip.length() && ip.charAt(i+1)=='X') {
						op += 9;
						i++;
					}
					else {
						op += 1;
					}
				}
				else if (ip.charAt(i)=='V') {
					op += 5;
				}
				else if(ip.charAt(i)=='X') {
					if(i+1 < ip.length() && ip.charAt(i+1)=='L') {
						op += 40;
						i++;
					}
					else if(i+1 < ip.length() && ip.charAt(i+1)=='C') {
						op += 90;
						i++;
					}
					else {
						op += 10;
					}
				}
				else if (ip.charAt(i)=='L') {
					op += 50;
				}
				else if(ip.charAt(i)=='C') {
					if(i+1 < ip.length() && ip.charAt(i+1)=='D') {
						op += 400;
						i++;
					}
					else if(i+1 < ip.length() && ip.charAt(i+1)=='M') {
						op += 900;
						i++;
					}
					else {
						op += 100;
					}
				}
				else if (ip.charAt(i)=='D') {
					op += 500;
				}
				else if (ip.charAt(i)=='M') {
					op += 1000;
				}
			}
			System.out.println(op);
		}
	}
}
