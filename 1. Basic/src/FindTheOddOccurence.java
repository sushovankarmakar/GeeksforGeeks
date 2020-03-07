import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindTheOddOccurence {

	//XOR operation on a number with itself even number of times will result in 0.
	//XOR operation on a number with itself odd number of times will result in the number itself.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), res = 0;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				res ^= ip[i];
			}
			System.out.println(res);
		}
	}
}
