import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Remove_consonants {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			boolean b = false;
			char s[] = br.readLine().toCharArray();
			for (int i = 0; i < s.length; i++) {
				if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' ||
				   s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U' || s[i] ==' ') {
					
					System.out.print(s[i]);
					b = true;
				}
			}
			if(!b) {
				System.out.print("No Vowel");
			}
			System.out.println();
		}
	}
}
