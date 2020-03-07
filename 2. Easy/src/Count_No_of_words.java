import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Count_No_of_words {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine();
			s = s.replace("\\t", " ");
			s = s.replace("\\n", " ");
			if(s.trim().compareTo("")==0) {
				System.out.println("0");
			}
			else{
				String op[] = s.trim().split("\\s+");
				/*for (int i = 0; i < op.length; i++) {
					System.out.println(op[i]);
				}*/
				System.out.println(op.length);
			}
		}
	}
}
