import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class FakeProfile {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine();
			HashMap<Character, Integer> map = new HashMap<>();
			int distinctChar=0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c=='a'|| c=='e' || c== 'i' || c=='o' || c=='u') {
					continue;
				}
				Integer val = map.get(c);
				if(val==null) {
					map.put(c, 1);
					distinctChar++;
				}
			}
			System.out.println((distinctChar%2!=0)?"HE!":"SHE!");
		}
	}
}
