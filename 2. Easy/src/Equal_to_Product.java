import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Equal_to_Product {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String np[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(np[0]);
			BigInteger p = new BigInteger(np[1]);
			long ip[] = new long[n];
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				ip[i] = Long.parseLong(s[i]);
			}
			Arrays.sort(ip);
			
			for (int i = 0; i < n; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();
			boolean b = false;
			BigInteger bi = BigInteger.ONE;
			for (int i = 0; i < n; i++) {
				
				if(BigInteger.valueOf(ip[i]).compareTo(p)<0) {
					bi = p.divide(BigInteger.valueOf(ip[i]));
					System.out.println(bi);
					b = binarySearch(ip, bi, i);
				}
			}
			System.out.println();
			
			/*
			outer: for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(i!=j) {
							BigInteger bi = BigInteger.valueOf(ip[i]*ip[j]);
							System.out.println(bi);
							if(bi.equals(p)) {
								b = true;
								break outer;
							}
						}
					}
				}*/
			System.out.println((b)?"Yes":"No");
		}
	}
	
	static boolean binarySearch(long ip[],BigInteger a,int index) {
		int mid = 0, l=index+1, r=ip.length-1;
		//System.out.println(a);
		while(l<=r) {
			mid = l + (r-l)/2;
			System.out.println("mid = "+ mid);
			BigInteger bi_mid = BigInteger.valueOf(ip[mid]);
			System.out.println("bi_mid = "+ bi_mid);
			if(a.compareTo(bi_mid)==0) {
				return true;
			}
			else if(a.compareTo(bi_mid)<0) {
				r = mid-1;
			}
			else if(a.compareTo(bi_mid)>0) {
				l = mid+1;
			}
		}
		return false;
	}
}
