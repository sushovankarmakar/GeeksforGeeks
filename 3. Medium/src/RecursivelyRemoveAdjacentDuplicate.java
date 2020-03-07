import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://ide.geeksforgeeks.org/ayqFs4sEym
// https://ide.geeksforgeeks.org/eIpKHfQyGl

class RecursivelyRemoveAdjacentDuplicate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			String op = removeDuplicate(ip);
			System.out.println(op);
		}
	}
	
	static String removeDuplicate(String ip) {

		if(ip.isEmpty()) return "";
		
		String op = "";
		boolean flag = false, rem = false;
		
		char temp = ip.charAt(0);
		
		for (int i = 1; i < ip.length(); i++) {
			if(temp != ip.charAt(i)) {
				if(!flag) {
					op += temp;
					//System.out.println(op);
				}
				else {
					flag = false;
				}
				temp = ip.charAt(i);
			}
			else {
				flag = true;
				rem = true;
			}
		}
		if(!flag) op += temp;
		//System.out.println(" before : "+ op);
		
		if(rem) op = removeDuplicate(op);
		
		return op;
	}
}
