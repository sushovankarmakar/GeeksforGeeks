import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashSet;


// https://www.geeksforgeeks.org/find-uncommon-characters-two-strings/


class UncommonCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine().trim());
		
		// Simple Algorithm  , execution time  = 0.06
		while(t-->0) {
			String a = br.readLine().trim(), b = br.readLine().trim();
			for (char c = 'a'; c <= 'z'; c++) {
				if( (a.indexOf(c) >=0 && b.indexOf(c) < 0 ) || (a.indexOf(c) < 0 && b.indexOf(c) >=0 ) ) {
					sb.append(c);
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
		
		
		// Algorithm with the help of HashSet , execution time  = 0.08
		
		/*while(t-->0) {
			HashSet<Character> setA = new HashSet<>(), setB = new HashSet<>(), setCopy = new HashSet<>();
			char[] a = br.readLine().trim().toCharArray(), b = br.readLine().trim().toCharArray();
			
			for (int i = 0; i < a.length; i++) {
				setA.add(a[i]);}
			
			for (int i = 0; i < b.length; i++) {
				setB.add(b[i]);}
			
			setCopy.addAll(setA); 	 // copying all the values of setA in setCopy, so that values of setA can be used later
			
			setA.removeAll(setB); 	 // getting all the values which are in setA but not in setB
			
			setB.removeAll(setCopy); // getting all the values which are in setB but not in setA 
			
			setB.addAll(setA);       // adding both setB and setB to get all the uncommon element
			 
			Object op[] = setB.toArray();
			Arrays.sort(op);
			
			// printing part
			for (int i = 0; i < op.length; i++) {
				sb.append(op[i]);
			}
			System.out.println(sb);
			sb.setLength(0);
		}*/
	}
}
