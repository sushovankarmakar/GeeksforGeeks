import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Binary_to_Decimal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			//one line answer for binary to Decimal
			System.out.println(Integer.parseInt(br.readLine(), 2));
			
			//one line answer for Decimal to binary
			
			/*	String s = br.readLine();
				String a = Integer.toString(Integer.parseInt(s), 2);
				String l = Integer.toBinaryString(Integer.parseInt(s));
			 */			
			
			/*long s = Long.parseLong(br.readLine());
			int decimal = 0;
			int power=0;
			while(s!=0)
			{
				int a = (int)(s % 10);  // taking each digits of binary number 
				int no = a * (int) Math.pow(2, power);  
				decimal += no ;  // adding with decimal 
				
				s /= 10;
				power++;
			}
			System.out.println(decimal); 
			*/
		}
	}
}






//this logic won't work for input 11111111111 because it will exceeds the Integer limit in java
/*
int s = Integer.parseInt(br.readLine());
int decimal = 0;
int power=0;
while(s!=0)
{
	int a = s % 10;  // taking each digits of binary number 
	int no = a * (int) Math.pow(2, power);  
	decimal += no ;  // adding with decimal 
	
	s /= 10;
	power++;
}
System.out.println(decimal); 
*/