import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CountNumbersDivisible_by_M {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int m = Integer.parseInt(s[2]);
			int count = 0;
			for (int i = a; i <= b; i++) {
				if(i%m==0) count++;
			}
			System.out.println(count);
		}
	}
}
