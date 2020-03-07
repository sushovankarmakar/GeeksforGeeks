import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PerfectSquares_in_a_Range {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int i = 1, sq = 1,c = 0;
			while(sq <= b) {
				
				if(a<=sq && sq<=b)  c++;
				
				i++;
				sq = i*i;
				
			}
			System.out.println(c);
		}
	}
}
