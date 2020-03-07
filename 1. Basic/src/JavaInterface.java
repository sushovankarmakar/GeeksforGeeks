import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

interface in1{
	void display(int p);
}

class JavaInterface {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			InterfaceTestClass obj = new InterfaceTestClass();
			obj.display(n);
		}
	}	
}

class InterfaceTestClass implements in1{
	public void display(int k) {
		int count = 0;
		for (int i = 2; i <= k; i++) {
			if(isPrime(i)) count++;
		}
		System.out.println(count);
	}

	boolean isPrime(int i) {
		boolean b = true;
		for (int j = 2; j <= (int)Math.sqrt(i); j++) {
			if(i%j==0) {
				b = false;
				break;
			}
		}
		return b;
	}
}
