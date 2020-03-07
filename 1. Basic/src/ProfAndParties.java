import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/

class ProfAndParties {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			long ip[] = new long[n];
			String op = "GIRLS";
			HashMap<Long, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				ip[i] = Long.parseLong(s[i]);
				Integer val = map.get(ip[i]);
				if(val!=null) {
					map.put(ip[i], val+1);
					/*System.out.print(map.put(ip[i], val+1)+" ");
					System.out.println();*/
					if(val+1 > 1) {
						op = "BOYS"; break;
					}
				}
				else {
					map.put(ip[i], 1);
					/*System.out.print(map.put(ip[i], 1)+" ");
					System.out.println();*/
				}
			}
			System.out.println(op);
		}
	}
}
