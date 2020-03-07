import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.geeksforgeeks.org/find-sum-non-repeating-distinct-elements-array/

class SumOfDistinctElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), sum = 0;
			String s[] = br.readLine().trim().split("\\s+");
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				Integer val = map.get(Integer.parseInt(s[i]));
				if(val!=null) {
					map.put(Integer.parseInt(s[i]), val+1);
				}
				else {
					map.put(Integer.parseInt(s[i]), 1);
					sum += Integer.parseInt(s[i]);
				}
			}
			System.out.println(sum);
		}
	}
}
