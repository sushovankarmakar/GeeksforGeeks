import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SumOfGivenRange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]), a = Integer.parseInt(s1[1]), b = Integer.parseInt(s1[2]), sum =0;
			for (int i = a; i <= b; i++) {
				sum += Integer.parseInt(s2[i]);
			}
			System.out.println(sum);
		}
	}
}
