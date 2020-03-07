import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class MajorityElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), major = n/2, ans = -1;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			HashMap<Integer,Integer> map = new HashMap<>();
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
				Integer val = map.get(ip[i]);			
				if(val!=null) {
					map.put(ip[i], new Integer(val+1));
					if(val>=major) {
						ans = ip[i];
						break;
					}
				}
				else {
					map.put(ip[i], 1);
				}
			}
			System.out.println(ans);
		}
	}
}
