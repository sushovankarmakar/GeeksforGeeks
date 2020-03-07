import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class MostFrequentWord_in_array {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			Arrays.sort(ip);
			
			for (int i = 0; i < ip.length; i++) {
				System.out.println(ip[i]);
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			int max = 1;
			for (int i = 0; i < n; i++) {
				String s = ip[i];
				Integer val = map.get(s);
				if(val!=null) {
					map.put(s, new Integer(val+1));
					if(val+1 > max)
						max = val+1;
				}
				else {
					map.put(s, 1);
				}
		
			}
			//System.out.println(map);
			
			
			for (int i = 0; i < n; i++) {
				String s = ip[i];
				int val = map.get(s);
				if(val == max) {
					System.out.println(s);
					break;
				}
			}
		}
	}
}
