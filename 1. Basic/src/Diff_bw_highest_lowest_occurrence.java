import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Diff_bw_highest_lowest_occurrence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
			for (int i = 0; i < ip.length; i++) {
				Integer val = map.get(ip[i]);
				if(val!=null) {
					map.put(ip[i], val+1);
				}
				else {
					map.put(ip[i], 1);
				}
			}
			
			for (int i = 0; i < ip.length; i++) {
				Integer val = map.get(ip[i]);
				if(val > max) max = val;
				if(val < min) min = val;
			}
			//System.out.println(max+" "+min);
			System.out.println(max-min);
		}
	}
}
