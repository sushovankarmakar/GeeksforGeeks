import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SingleNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < ip.length; i++) {
				Integer val = map.get(ip[i]);
				if(map.containsKey(ip[i])) {
					map.put(ip[i], new Integer(val+1));
				}
				else {
					map.put(ip[i], 1);
				}
			}
			
			int ans = 0;
			for (int i = 0; i < ip.length; i++) {
				Integer val = map.get(ip[i]);
				if( (val%2)!=0 ) {
					ans = ip[i];
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
