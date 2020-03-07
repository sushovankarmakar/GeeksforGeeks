import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


class JavaCollectionHashMap1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < (n*2); i += 2) {
				
				String s = ip[i];
				Integer val = Integer.parseInt(ip[i+1]);
				map.put(s, val);
			}

			//printing purpose
			/*for (int i = 0; i < (n*2); i +=2 ) {
				System.out.println(ip[i]+" "+map.get(ip[i]));
			}*/
			
			
			String op = br.readLine().trim();
			if(map.containsKey(op)) {
				System.out.println(map.get(op));
			}
			else {
				System.out.println("-1");
			}
		}
	}
}
