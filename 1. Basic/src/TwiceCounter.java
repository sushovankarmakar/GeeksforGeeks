import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

// https://stackoverflow.com/questions/12455737/how-to-iterate-over-a-set-hashset-without-an-iterator

class TwiceCounter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			
			HashMap<String,Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				
				Integer val = map.get(ip[i]);
				if(val != null) {
					map.put(ip[i], val+1);
				}
				else {
					map.put(ip[i], 1);
				}
			}
			System.out.println(map);
			
			/* map.keySet() returns a Set view of the keys contained in this map.The set is backed by the map, 
			so changes to the map are reflected in the set, and vice-versa */
			
			System.out.println(map.keySet());
			
			Iterator<String> value = map.keySet().iterator();
			int count = 0;
			while(value.hasNext()) {
				if(map.get(value.next())==2) count++;
			}
			System.out.println(count);
		}
	}
}
