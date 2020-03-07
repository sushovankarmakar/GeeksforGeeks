import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PatternSearching {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String txt = br.readLine().trim() , pat = br.readLine().trim();
			boolean b = false;
			for (int i = 0; i <= (txt.length()-pat.length()) ; i++) {
				String s = txt.substring(i, i+pat.length());
				//System.out.println(s);
				if(s.equals(pat)) {
					b = true;
					break;
				}
			}
			System.out.println((b)?"found":"not found");
		}
	}
}
