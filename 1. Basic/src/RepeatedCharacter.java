import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class RepeatedCharacter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			char ch[] = br.readLine().trim().toCharArray();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < ch.length; i++) {
				Integer val = map.get(ch[i]);
				if(val!=null) {
					map.put(ch[i], val+1);
				}
				else {
					map.put(ch[i], 1);
				}
			}
			boolean b = false;
			for (int i = 0; i < ch.length; i++) {
				if(map.get(ch[i])>1) {
					System.out.println(ch[i]);
					b = true;
					break;
				}
			}
			if(!b) System.out.println("-1");
		}
	}
}
