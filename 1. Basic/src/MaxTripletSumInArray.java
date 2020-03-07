import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;

// had a problem in GFG site. tried every bit but everytime it shwos time limit exceed.

class MaxTripletSumInArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuffer sb = new StringBuffer();
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
			
			int max1 = 0, max2 = 0, max3 = 0;
			if(a>b) {
				if(b > c) { max1 = a; max2 = b; max3 = c;}
				else {
					max3 = b;
					if(a > c) { max1 = a; max2 = c;}
					else { max1 = c; max2 = a;}
				}
			}
			else { // (a<b)
				if(b > c) {
					max1 = b;
					if(c > a) { max2 = c; max3 = a;}
					else 	  { max2 = a; max3 = c;}
				}
				else { // (b<c)
					max1 = c; max2 = b; max3 = a;}
			}
			//System.out.println(max1+" "+max2+" "+max3);
			for (int i = 3; i < n; i++) {
				int no = Integer.parseInt(s[i]);
				if(no > max1 ) 		{ max3 = max2 ; max2 = max1; max1 = no; }
				else if(no > max2 ) { max3 = max2 ; max2 = no; }
				else if(no > max3 ) { max3 = no; }
				
				//System.out.println(max1+" "+max2+" "+max3);
			}
			int result = max1+max2+max3;
			sb.append(result);
			System.out.println(sb);
			sb.setLength(0);
			// aprroach -1 : giving time limit exceed problem. taking 0.48sec
			/*
			int ip[] = new int[n];
			Arrays.sort(ip);
			System.out.println(ip[n-3]+ip[n-2]+ip[n-1]);*/
		}
	}
}
