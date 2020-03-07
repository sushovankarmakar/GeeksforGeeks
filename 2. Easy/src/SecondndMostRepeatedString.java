import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


class SecondndMostRepeatedString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			HashMap<String, Integer> map = new HashMap<>();
			int max = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
			//String maxString="",maxString2="";
			
			for (int i = 0; i < s.length; i++) {
				Integer val = map.get(s[i]);
				
				if(val!=null) {
					map.put(s[i], val+1);
					
					if(val+1 > max) {
						max = val+1;
					}
				}
				else {
					map.put(s[i], 1);
				}
			}
			
			String max2_String = "";
			int d = 0;
			for (int i = 0; i < s.length; i++) {
				Integer val = map.get(s[i]);
				
				if(val!=max) {
					d = max-val;
					
					if(d < diff) {
						diff = d;
						max2_String = s[i];
					}
				}
			}
			System.out.println(max2_String);
			//System.out.println(max);
		}
	}
}
