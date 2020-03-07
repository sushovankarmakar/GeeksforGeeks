import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

class JavaCollectionsTreeSet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			TreeSet<String> ts = new TreeSet<>();
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				ts.add(s[i]);
			}
			char a = br.readLine().trim().charAt(0);
			char b = br.readLine().trim().charAt(0);
			char c = br.readLine().trim().charAt(0);
			char d = br.readLine().trim().charAt(0);
			task(ts,a,b,c,d);
		}
	}

	static void task(TreeSet<String> ts, char a, char b, char c, char d) {
		
		//print all the strings which are less than a
		System.out.println(ts.headSet(String.valueOf(a)));
		
		//print all the strings which are greater than or equal to b
		System.out.println(ts.tailSet(String.valueOf(b)));
		
		//print all the strings which are greater than or equal to c and less than d i.e between c and d ( excluding d )
		System.out.println(ts.subSet(String.valueOf(c),String.valueOf(d)));
	}
}
