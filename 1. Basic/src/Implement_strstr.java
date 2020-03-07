import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Implement_strstr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String sx[] = br.readLine().trim().split("\\s+");
			String s = sx[0], x = sx[1];
			System.out.println(strstr(s,x));
		}
	}
	
	static int strstr(String str, String target) {
		/*int lengthX = target.length();
		for (int i = 0; i <= str.length()-lengthX; i++) {
			String tempString = str.substring(i, i+lengthX);
			if(tempString.equals(target)) {
				return i;
			}
		}
		return -1;*/
		
		// single line answer
		return (str.contains(target)? str.indexOf(target) : -1 );
	}
}
