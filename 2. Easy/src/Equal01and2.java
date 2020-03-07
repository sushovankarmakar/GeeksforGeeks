import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Equal01and2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			int subStringCount = 0, zeroCount = 0, oneCount = 0, twoCount = 0;
			
			for (int i = 0; i < ip.length(); i++) {
				
				if(Character.getNumericValue(ip.charAt(i))==0) zeroCount++;
				else if(Character.getNumericValue(ip.charAt(i))==1) oneCount++;
				else twoCount++;
				
				for (int j = i+1; j < ip.length(); j++) {
					
					if(Character.getNumericValue(ip.charAt(j))==0) zeroCount++;
					else if(Character.getNumericValue(ip.charAt(j))==1) oneCount++;
					else twoCount++;
					
					if(zeroCount==oneCount && oneCount==twoCount) {
						subStringCount++;
					}
				}
				zeroCount = 0; oneCount = 0; twoCount = 0;  
			}
			System.out.println(subStringCount);
		}
	}
}
