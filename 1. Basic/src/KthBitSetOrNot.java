import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class KthBitSetOrNot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int k = Integer.parseInt(br.readLine().trim());
			String s = String.format("%32s", Integer.toBinaryString(n)).replace(" ", "0");
			System.out.println((s.charAt(s.length()-k-1)=='1')?"Yes":"No");
		}
	}
}
