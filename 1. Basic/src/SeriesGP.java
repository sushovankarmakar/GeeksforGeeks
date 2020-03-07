import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SeriesGP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(br.readLine());
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			double d = (double)b/a;
			//System.out.println(d);
			//int r = (int)Math.floor(d);
			double pow = Math.pow(d, (n-1));
			double op = ((double)a) * pow;
			System.out.println((int)op);
		}
	}
}
