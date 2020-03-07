import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Diff_bw_sumOfOdd_n_Even_digit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] s = br.readLine().trim().split("");
			int sumOdd = 0, sumEven=0;
			for (int i = 0; i < s.length; i++) {
				if(i%2!=0) sumOdd += Integer.parseInt(s[i]);
				else sumEven += Integer.parseInt(s[i]);
			}
			System.out.println(((sumOdd-sumEven)==0)?"Yes":"No");
		}
	}
}
