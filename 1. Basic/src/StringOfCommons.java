import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class StringOfCommons {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			char ip1[] = br.readLine().trim().toCharArray(), ip2[] = br.readLine().trim().toCharArray();
			Set <Character> set1 = new HashSet<>(), set2 = new HashSet<>();
			
			for (int i = 0; i < ip1.length; i++) {	set1.add(ip1[i]);	}
			for (int i = 0; i < ip2.length; i++) {	set2.add(ip2[i]);	}
			
			set1.retainAll(set2);
			
			String op = "";
			Iterator<Character> itr = set1.iterator();
			while(itr.hasNext()) {
				op += itr.next();
			}
			char ch[] = op.toCharArray();
			Arrays.sort(ch);
			
			if(op.compareTo("")==0) System.out.println("nil");
			else
			System.out.println(String.valueOf(ch));
		}
	}
}
