import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Stack;

// https://leetcode.com/articles/longest-valid-parentheses/
// https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

class ValidSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int longestLength = 0;
			String ip = br.readLine().trim();

			int op[] = new int[ip.length()];
			for (int i = 0; i < op.length; i++) {
				op[i] = 0;
			}
			for (int i = 1; i < ip.length(); i++) {
				if(ip.charAt(i)==')') {
					if(ip.charAt(i-1) == '(' ) {
						op[i] = ( (i>=2)? op[i-2] : 0 ) + 2;
					}
					else if(i-op[i-1] > 0 && ip.charAt(i-op[i-1]-1) == '(' ) {
						op[i] = op[i-1]+ ((i-op[i-1]>=2)? op[i-op[i-1]-2] : 0 ) + 2;
					}
				}
				if(op[i] > longestLength) longestLength = op[i];
			}
			/*for (int i = 0; i < op.length; i++) {
				System.out.print(op[i]+" ");
			}
			System.out.println();*/
			System.out.println(longestLength);
			
			
			
			/*for (int i = 0; i < ip.length()-1; i++) {
			for (int j = i+1; j <= ip.length(); j++) {
				String subStr = ip.substring(i, j);
				//System.out.println(subStr);
				if(subStr.endsWith(")")) {
					//System.out.println(subStr);
					int len = subStr.length();
					if(isMatched(subStr)) {
						if(len > longestLength) longestLength = len;
						}
					}
				}
			}
			System.out.println(longestLength);*/
		}
	}
	
	/*public static boolean isMatched(String subStr) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < subStr.length(); i++) {
			
			char c1 = subStr.charAt(i);
			
			if(c1=='(') st.push(c1);
			else if(c1==')'){
				
				if(st.isEmpty()) return false;
				else {
					char c2 = st.pop();
					if(c2=='(' && c1==')') continue;
					else return false;
				}
			}
		}
		
		
		if(st.isEmpty()) return true;
		else return false;
	}*/
	
}
