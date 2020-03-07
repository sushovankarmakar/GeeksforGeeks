import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

class Permutations_of_String {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine();
			Arrays.sort(s.toCharArray());
			ArrayList<String> str = new ArrayList<>();
			
			findPermutation(s,0,s.length()-1, str);
			
			Collections.sort(str.subList(0, str.size())); // sorting the output
			for (int i = 0; i < str.size(); i++) {
				System.out.print(str.get(i)+" ");
			}
			System.out.println();
		}
	}
	
	private static void findPermutation(String s,int l,int r, ArrayList<String> str) {
		if(l==r) {
			System.out.println(s+" "+l);
			str.add(s);
		}
		else {
			for (int i = l; i <= r; i++) {
				s= swap(s,l,i);
				findPermutation(s, l+1, r, str);
				s= swap(s,l,i);
			}
		}
	}
	
	private static String swap(String s,int l,int r) {
		
		char[] ch = s.toCharArray();
		char temp = s.charAt(l);
		ch[l] = s.charAt(r);
		ch[r] = temp;
		return String.valueOf(ch);
	}
}
