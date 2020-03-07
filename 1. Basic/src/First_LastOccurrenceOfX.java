import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class First_LastOccurrenceOfX {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			//StringBuffer sb = new StringBuffer();
			long ip[] = new long[n];
			long x = Long.parseLong(br.readLine().trim());
			int f = -1, l = f ;
			boolean b = false;
			for (int i = 0; i < s.length; i++) {
				ip[i] = Long.parseLong(s[i]);
				if(ip[i]==x && !b) {
					f = l = i;
					b = true;
				}
				else if(ip[i]==x && b ) {
					l=i;
				}
			}
			//System.out.println(bSearch(ip, 0, ip.length-1, x));
			if(!b) System.out.println(f);
			else System.out.println(f+" "+l);
		}
	}
	
	//cound't solve by using binary search
	/*//used binary search to find the x
	static String bSearch(long ip[],int l,int r,long x) {
		
		if(l<=r) {
			int mid = l+(r-l)/2;
			System.out.println("mid "+mid);
			if(ip[mid]==x) {
				int a = mid,b =mid; 
				if( ( (--mid) >= 0) && (ip[--mid]==x) ) {
					a = findX(ip,x,mid--,'l');
				}
				if( ( (++mid) <= (ip.length-1) ) && (ip[++mid]==x) ) {
					b = findX(ip,x,mid++,'r');
				}
				
				String s = a+" "+b;
				System.out.println(s);
				return s;
			}
			else if(ip[mid] > x) {
				System.out.println("Lesser");
				bSearch(ip,l,mid-1,x);
			}
			else if(ip[mid] < x) {
				System.out.println("Greater");
				bSearch(ip,mid+1,r,x);
			}
		}
		return "";
	}
	
	static int findX(long ip[],long x,int pos, char c) {
		
		if(c=='l') {
			while(ip[pos]==x) {
				if( pos-- > 0 ) 
					continue;
				else break;
			}
			pos++;
		}
		else if(c=='r') {
			while(ip[pos]==x) {
				if( pos++ < ip.length )
					continue;
				else break;
			}
			pos--;
		}
		System.out.println("pos "+ pos);
		return pos;
	}*/
}
