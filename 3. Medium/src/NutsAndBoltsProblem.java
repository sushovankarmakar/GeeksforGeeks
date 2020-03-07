import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

// https://practice.geeksforgeeks.org/editorial.php?pid=496

class NutsAndBoltsProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String nuts[] = br.readLine().trim().split("\\s+"), bolts[] = br.readLine().trim().split("\\s+");
			LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
			String nutsBolts[] = { "!", "#", "$", "%", "&", "*", "@", "^", "~" };
			for (int i = 0; i < 9; i++) {
				map.put(nutsBolts[i], null);
			}
			
			for (int i = 0; i < n; i++) {
				Integer val1 = map.get(nuts[i]);
				if(val1!=null) {
					map.put(nuts[i], val1+1);
				}
				else {
					map.put(nuts[i], 1);
				}
				
				Integer val2 = map.get(bolts[i]);
				if(val2!=null) {
					map.put(bolts[i], val2+1);
				}
				else {
					map.put(bolts[i], 1);
				}
			}
			
			for (int i = 0; i < 9; i++) {
				Integer val = map.get(nutsBolts[i]);
				if(val != null && val == 2) System.out.print(nutsBolts[i]+" ");
			}
			System.out.println();
			
			for (int i = 0; i < 9; i++) {
				Integer val = map.get(nutsBolts[i]);
				if(val != null && val == 2) System.out.print(nutsBolts[i]+" ");
			}
			System.out.println();
		}
	}
}
