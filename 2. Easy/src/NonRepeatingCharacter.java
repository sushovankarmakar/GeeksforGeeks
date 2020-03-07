import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class NonRepeatingCharacter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			HashMap<Character, Integer> map = new HashMap<>();
			int l = Integer.parseInt(br.readLine().trim());
			String s = br.readLine();
			for (int i = 0; i < l; i++) {
				char c = s.charAt(i);
				Integer val = map.get(c);
				if(val!=null) {
					map.put(c, new Integer(val+1));
				}
				else {
					map.put(c, 1);
				}
			}
			
			boolean nonRepeat = false;
			for (int i = 0; i < l; i++) {
				char c = s.charAt(i);
				Integer val = map.get(c);
				if(val.equals(new Integer(1))) {
					System.out.println(c);
					nonRepeat = true;
					break;
				}
			}
			if(!nonRepeat) {
				System.out.println(-1);
			}
		}
	}
}
