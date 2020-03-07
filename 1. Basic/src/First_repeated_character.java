import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class First_repeated_character {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			HashMap<Character,Integer> map = new HashMap<>();
			String s = br.readLine();
			boolean repeat = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Integer no = map.get(c);
				if(no!=null) {
					System.out.println(c);
					repeat = true;
					break;
				}
				else {
					map.put(c, 1);
				}
			}
			
			if(!repeat) System.out.println(-1);
		}
	}
}
