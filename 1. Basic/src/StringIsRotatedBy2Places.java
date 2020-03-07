import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/

class StringIsRotatedBy2Places {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip1 = br.readLine().trim(),ip2 = br.readLine().trim();
			int l = ip2.length();
			boolean b = true;
			for(int i=0; i < l; i++){
				/*System.out.println(ip2.charAt(i));
				System.out.println(ip1.charAt((i+2)%l));
				System.out.println(ip1.charAt((i+l-2)%l));*/
				
			    if( ip2.charAt(i)!=ip1.charAt((i+2)%l) && ip2.charAt(i)!=ip1.charAt((i+l-2)%l)) {
			        b = false;
			        break;
			    }
			}
			System.out.println((b)?"1":"0");
		}
	}

}
