import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LenOfLongestWordInSentence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int len = 0;
			for (int i = 0; i < s.length; i++) {
				int l = s[i].length();
				if(l > len) len = l;
			}
			System.out.println(len);
		}
	}
}
