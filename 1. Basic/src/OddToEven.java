import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class OddToEven {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			
			String num[] = br.readLine().trim().split("");
			String op = "0";
			
			//int lastDigit = Integer.parseInt(num[num.length-1]);
			
			for (int i = 0; i < num.length-1; i++) {
				int d = Integer.parseInt(num[i]);
				
				if(d%2 == 0) {
					int temp = Integer.parseInt(num[num.length-1]);
					num[num.length-1] = String.valueOf(Integer.parseInt(num[i]));
					num[i] = String.valueOf(temp);
					
					String op1 ="";
					for (int j = 0; j < num.length; j++) {
						op1 += num[j];
					}
					if(Integer.parseInt(op) < Integer.parseInt(op1)) op = op1;
					
					
					temp = Integer.parseInt(num[num.length-1]);
					num[num.length-1] = String.valueOf(Integer.parseInt(num[i]));
					num[i] = String.valueOf(temp);
				}
			}
			if(op.compareTo("0")==0) {
				
				for (int i = 0; i < num.length; i++) {
					System.out.print(num[i]); 
				}
				System.out.println();
			}
			else System.out.println(op);
		}
	}
}
