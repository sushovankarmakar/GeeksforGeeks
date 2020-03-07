import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class FindMaxNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			char ip[] = br.readLine().trim().toCharArray();
			Arrays.sort(ip);
			StringBuffer sb = new StringBuffer(String.valueOf(ip));
			System.out.println(sb.reverse());
		}
	}
}
