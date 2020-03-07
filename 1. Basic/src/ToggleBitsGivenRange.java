import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ToggleBitsGivenRange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int no = Integer.parseInt(ip[0]), l = Integer.parseInt(ip[1]), r = Integer.parseInt(ip[2]);
			char s[] = String.format("%32s", Integer.toBinaryString(no)).replace(' ', '0').toCharArray();

			for (int i = 32-l; i >= (32-r); i--) {
				
				if(s[i]=='0') s[i] = '1';
				else s[i] = '0';
			}
			System.out.println(Integer.parseInt(String.valueOf(s),2));
		}
	}
}
