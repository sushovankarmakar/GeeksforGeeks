import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

class TwoRepeatedElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n+2; i++) {
				Integer val = map.get(Integer.parseInt(s[i]));
				if(val!=null) {
					map.put(Integer.parseInt(s[i]), val);
					sb.append(s[i]+" ");
				}
				else {
					map.put(Integer.parseInt(s[i]), 1);
				}
			}
			System.out.println(sb);
		}
	}
}
