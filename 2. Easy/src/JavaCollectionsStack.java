import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class JavaCollectionsStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuffer sb = new StringBuffer();
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			Stack<Integer> s = new Stack<Integer>();
			int mid = n/2;
			for (int i = 0; i < n; i++) {
				s.push(Integer.parseInt(ip[i]));
			}
			for (int i = 0; i < n; i++) {
				if(i==mid) {
					s.pop();
				}
				else {
					sb.append(s.pop()+" ");
				}
			}
			System.out.println(sb);
			sb.delete(0, sb.length()); // clearing stringbuffer after each loop
			//sb.setLength(0);
		}
	}
}
