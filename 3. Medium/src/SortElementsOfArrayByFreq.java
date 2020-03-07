import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

// https://www.geeksforgeeks.org/comparator-interface-java/
// https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
// https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/
// https://practice.geeksforgeeks.org/editorial.php?pid=493


class SortElementsOfArrayByFreq {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				Integer value = map.get(Integer.parseInt(ip[i]));
				if(value!=null) {
					map.put(Integer.parseInt(ip[i]), value+1);
				}
				else {
					map.put(Integer.parseInt(ip[i]), 1);
				}
			}
			
			System.out.println(map.entrySet());
			
			List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
			
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
				public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
					int compareValue = m1.getValue().compareTo(m2.getValue());
					int compareKey = m2.getKey().compareTo(m1.getKey());
					if(compareValue==0) {
						return (compareKey==0)? compareValue : compareKey;
					}
					else {
						return compareValue;
					}
				}
			});
			
			Collections.reverse(list);
			System.out.println(list);
			
			for (Map.Entry<Integer, Integer> entry : list) {
				int a = entry.getValue();
				while(a-->0) {
					System.out.print(entry.getKey()+" ");
				}
			}
			System.out.println();
		}
	}
}
