import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BooleanStringValue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			char ip[]= br.readLine().trim().toCharArray();
			int op = 0;
			int a = Integer.parseInt(String.valueOf(ip[0]));
			
			for ( int i = 1; i < ip.length-1; i +=2 ) {
				
				//System.out.println(i);
				char c = ip[i];
				int b = Integer.parseInt(String.valueOf(ip[i+1]));
				//System.out.println(a+" "+b+" "+c);
				
				if(c=='A') { //AND
					if( a==1 && b==1 ) op = 1;
					else op = 0;
				}
				else if(c=='B') { //OR
					if( a==0 && b==0 ) op = 0;
					else op = 1;
				}
				else if(c=='C') { //XOR
					if( (a==0 && b==1) || (a==1 && b==0) ) 	op = 1;
					else op = 0;
				}
				a = op;
				//System.out.println(a);
			}
			System.out.println(op);
		}
	}
}
