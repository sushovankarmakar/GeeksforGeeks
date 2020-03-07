import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class EditDistance {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String l[] = br.readLine().trim().split("\\s+");
			int p = Integer.parseInt(l[0]), q = Integer.parseInt(l[1]);
			String s[] = br.readLine().trim().split("\\s+");
			String s1 = s[0] , s2 = s[1];
			
			int op[][] = new int[p+1][q+1];
			for (int i = 1; i < op.length; i++) {
				for (int j = 1; j < op[i].length; j++) {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						op[i][j] = op[i-1][j-1];
					}
					else {
						op[i][j] = Math.min(op[i-1][j-1], Math.min(op[i-1][j], op[i][j-1])) + 1;
					}
				}
			}
			
			System.out.println(op[p][q]);
			
			/*if(s1.length() >= s2.length()) {
				System.out.println(s1.length() - op[p][q]);
			}
			else {
				System.out.println(s2.length() - op[p][q]);
			}*/
		}
	}
}
