import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PatternMatcherJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			int count = 0;
			for (int i = 0; i < ip.length(); i++) {
				if(ip.charAt(i)=='x') count++;
				else count--;
				
				if(count < 0) break;
			}
			System.out.println((count==0)?"1":"0");
		}
	}
}
