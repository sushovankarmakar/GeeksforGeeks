import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/

class TwoNumWithOddOccurrences {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),a=-1,b=-1;
			String s[] = br.readLine().trim().split("\\s+");
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				Integer val = map.get(Integer.parseInt(s[i]));
				if(val!=null) {
					map.put(Integer.parseInt(s[i]), val+1);
				}
				else {
					map.put(Integer.parseInt(s[i]),1);
				}
			}
			//System.out.println(map);
			
			int count = 2;
			for (int i = 0; i < n; i++) {
				Integer val = map.get(Integer.parseInt(s[i]));
				if(val%2!=0 ) {
					if(count==2 && a !=Integer.parseInt(s[i])) {
						a = Integer.parseInt(s[i]);
						//System.out.println(a);
					}
					else {
						b = Integer.parseInt(s[i]);
						//System.out.println(b);
					}
					count--;
				}
				if(a!=-1 && b!=-1 && (a!=b)) break;
			}
			if(a>=b) System.out.println(a+" "+b);
			else 	 System.out.println(b+" "+a);
		}
	}
}
