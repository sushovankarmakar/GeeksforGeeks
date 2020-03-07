import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class NonRepetitiveString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			char ip[] = br.readLine().trim().toCharArray();
			boolean nonRep = true;
			for (int i = 0; i < ip.length-1; i++) {
				if(ip[i]!=ip[i+1]) {
					for (int j = i+1; j < ip.length; j++) {
						if(ip[i]==ip[j]) {
							nonRep = false;
							break;
						}
					}
				}
			}
			System.out.println((nonRep)?"1":"0");
		}
	}
}
