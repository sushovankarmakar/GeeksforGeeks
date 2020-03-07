import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Winner_of_an_election {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			//Arrays.sort(ip);
			
			int max = 1;
			String winner = "z";
			HashMap<String, Integer> map = new HashMap<>();
			
			for (String s:ip) {
				
				Integer val = map.get(s);
				if(map.containsKey(s)) {
					map.put(s, val+1);
					
					if(val+1 > max)  max = val+1; 
				}
				else {
					map.put(s, 1);
				}
			}
			
			for (String s : ip) {
				int val = map.get(s);
				if(max==val) {
					if( winner.compareTo(s)>0) {
						winner = s;
					}
				}
			}
			System.out.println(winner+" "+max);
		}
	}
}
