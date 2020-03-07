import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class SeriesAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int a[] = new int[2];
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(br.readLine());
			int op = Integer.parseInt(s[0]) +  (  (Integer.parseInt(s[1]))- (Integer.parseInt(s[0]))  )*(n-1);
			System.out.println(op);
		}
	}

}
