import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ImplementStackUsingArray {

	static class Stack{
		int stackArr[] = new int[1000];
		int top;
		Stack(){
			top = -1;
		}
		
		boolean isEmpty() {
			return (top < 0);
		}
		
		void push(int val) {
			if(top > 1000) {
				System.out.println("Overflow");
			}
			else {
				stackArr[++top] = val;
			}
		}
		void pop() {
			if(top < 0) {
				System.out.println("Underflow");
			}
			else {
				int val = stackArr[top--];
				System.out.print(val+" ");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			
			Stack st = new Stack();
			for (int i = 0; i < n; ) {
				int action = Integer.parseInt(s[i]);
				if(action==1) {
					st.push(Integer.parseInt(s[i+1]));
					i+=2;
				}
				else {
					st.pop();
					i++;
				}
			}
		}
	}
}
