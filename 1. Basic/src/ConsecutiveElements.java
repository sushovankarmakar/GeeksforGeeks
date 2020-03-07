import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/editorial.php?pid=182


class ConsecutiveElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim(),op= ""+ip.charAt(0);
			for (int i = 0; i < ip.length()-1; i++) {
				if(ip.charAt(i)==ip.charAt(i+1)) {
					//System.out.println(ip.charAt(i));
					continue;
				}
				else {
					op += ip.charAt(i+1);
					//System.out.println(op);
				}
			}
			System.out.println("OP "+op);
		}
	}
}
