import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class AbsoluteDiffOf1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nk[] = br.readLine().trim().split("\\s+"), ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				if(k > Long.parseLong(ip[i]) && ip[i].length() > 1) {
					if(diff(ip[i])) sb.append(ip[i]+" ");
				}
			}
			System.out.println( (sb.length() > 0)?sb:"-1" );
		}
	}

	static boolean diff(String no) {
		char ip[] = no.toCharArray();
		for (int i = 0; i < ip.length-1; i++) {
			int a = Character.getNumericValue(ip[i]), b = Character.getNumericValue(ip[i+1]);
			if( Math.abs(a-b)!=1 ) return false;
		}
		return true;
	}
}
