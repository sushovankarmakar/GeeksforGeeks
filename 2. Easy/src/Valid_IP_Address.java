import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://leetcode.com/problems/validate-ip-address/discuss/95491/Java-Simple-Solution

class Valid_IP_Address {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			System.out.println(isValidIP(ip)?"1":"0");
		}
	}
	
	static boolean isValidIP(String ip) {
		
		if(ip.length() < 7) return false;
		
		if(ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.') return false;
		
		String parts[] = ip.split("\\.");
		
		if(parts.length!=4) return false;
		
		for (String part : parts) {
			System.out.println(part);
			
			if(part.length() > 3) return false;
			
			if(part.charAt(0)=='0' && part.length()!=1) return false;
			
			for (int i = 0; i < part.length(); i++) {
				if(!Character.isDigit(part.charAt(i))) return false;
			}
			
			if(Integer.parseInt(part)<0 || Integer.parseInt(part)> 255) return false;
		}
		return true;
	}
}
