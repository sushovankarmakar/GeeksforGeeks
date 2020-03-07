import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Find_unique_element {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
			String s1[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s1[i]);
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < ip.length; i++) {
				Integer val = map.get(ip[i]);
				if(val != null) {
					map.put(ip[i], new Integer(val+1));
				}
				else {
					map.put(ip[i], 1);
				}
			}
			
			for (int i = 0; i < ip.length; i++) {
				int val = map.get(ip[i]);
				if(val==1) {
					System.out.println(ip[i]);
					break;
				}
			}
		}
	}
}
