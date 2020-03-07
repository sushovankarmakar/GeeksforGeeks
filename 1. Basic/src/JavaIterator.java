import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// https://www.geeksforgeeks.org/iterators-in-java/

class JavaIterator {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]),k = Integer.parseInt(s1[1]);
			ArrayList<Integer> ip = new ArrayList<>();
			String s2[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				ip.add(Integer.parseInt(s2[i]));
			}
			Iterator<Integer> itr = ip.iterator();
			while(itr.hasNext()) {
				int i = itr.next();
				if(i<k) itr.remove();
			}
			Collections.sort(ip);
			System.out.println(ip);
		}
	}
}
