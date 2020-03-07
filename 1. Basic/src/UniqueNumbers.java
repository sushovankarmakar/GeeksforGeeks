import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//easier solution link : https://www.geeksforgeeks.org/numbers-unique-distinct-digits/ 


class UniqueNumbers {

	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int m = Integer.parseInt(s1[0]), n = Integer.parseInt(s1[1]);
			
			for (int i = m; i <=n; i++) {
				int no = i;
				boolean b = checkUniqueDigit(no);
				if(b) sb.append(no+" ");
			}
			System.out.println(sb);
		}
	}

	static boolean checkUniqueDigit(int no) {
		
		boolean b = false;
		while(no > 0) {
			int d = no%10;
			Integer val = map.get(d);
			if(val==null) {
				b = true;
				map.put(d, 1);
			}
			else {
				b = false;
				break;
			}
			no = no/10;
		}
		map.clear();
		return b;
	}
}
