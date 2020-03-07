import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.math.BigInteger;

class MultiplyByEleven_IN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip = br.readLine().trim();
			String op = "";
			op = ip + ip.substring(0, ip.length()-1);
			op = op + ip.substring(ip.length()-1, ip.length());
			System.out.println(op);
			
			
			//char op[] = new char[ip.length+1];
			//op[0] = ip[0]; op[op.length-1] = ip[ip.length-1];
			int rem = 0;
			/*for (int i = ip.length-2 ; i >= 0 ; i--) {
				int a = Integer.parseInt(String.valueOf(ip[i]));
				int b = Integer.parseInt(String.valueOf(ip[i+1]));
				int sum = a + b + rem;
				
				rem = 0;
				if(sum > 9) {
					rem = sum / 10;
					sum = sum % 10;
				}
				
				op[i+1] = (char)(sum+'0'); 
			}*/
			
			/*for (int i = 0; i < op.length; i++) {
				System.out.print(op[i]);
			}*/
			System.out.println();
		}
	}
}

/*
BigInteger b = new BigInteger(ip);
b = b.multiply(BigInteger.valueOf(11));
char no1[] = ("0" + ip).toCharArray();
char no2[] = (ip + "0").toCharArray();


//String result = ""+no1[no1.length-1];
			char op[] = new char[ip.length+1];
			op[0] = ip[0]; op[op.length-1] = ip[ip.length-1];
			int rem = 0;
			for (int i = ip.length-2 ; i >= 0 ; i--) {
				int a = Integer.parseInt(String.valueOf(ip[i]));
				int b = Integer.parseInt(String.valueOf(ip[i+1]));
				int sum = a + b + rem;
				A
				//System.out.print("sum "+ sum); System.out.println(" rem "+ rem);
				
				rem = 0;
				if(sum > 9) {
					rem = sum / 10;
					sum = sum % 10;
				}
				//System.out.println("sum "+ sum);
				//result = result + String.valueOf(sum);
				//System.out.println("i "+ i);
				op[i+1] = (char)(sum+'0'); 
			}
			
			for (int i = 0; i < op.length; i++) {
				System.out.print(op[i]);
			}
			System.out.println();
			char op[] = result.toCharArray();
			for (int i = op.length-1; i >=0 ; i--) {
				System.out.print(op[i]);
			}
			System.out.println();
			//System.out.println(new StringBuffer(result).reverse());



*/