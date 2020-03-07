import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


class NextLargerElement {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			String ip[] = br.readLine().trim().split("\\s+");
			
			// Approach-3; this approach print the output in the same order as input
			StringBuffer sb = new StringBuffer();
			long op[] = new long[n];
			Stack<Long> st = new Stack<>();
			
			// traversing backwardly
			for (int i = n-1; i >= 0; i--) {
				
				long no = Long.parseLong(ip[i]);
				while(!st.isEmpty() && st.peek() < no ) {
					st.pop();
				}
				if(st.isEmpty()) op[i] = -1;
				else op[i] = st.peek();
				st.push(no);
			}
			
			for (int i = 0; i < op.length; i++) {
				sb.append(op[i]+" ");
			}
			System.out.println(sb);
			
			// Approach-2; this approach doesn't print the output in the same order as input 
			/*Stack<Integer> st = new Stack<>();
			st.push(Integer.parseInt(ip[0])); //pushing the first element in the stack;
			for (int i = 1; i < n; i++) {
				int no = Integer.parseInt(ip[i]);
				while( !st.isEmpty() &&  (st.peek() <= no) ) {
					System.out.println("Num "+st.peek() +" NGE "+no);
					st.pop();
				}
				st.push(no);
			}
			while(!st.isEmpty()) {
				System.out.println("Num "+st.pop() +" NGE "+-1);
			}*/
			
			// Approach-1; 0(n^2)
			/*
			 int a[] = new int[n];
			 for (int i = 0; i < ip.length-1; i++) {
				int op = a[i];
				for (int j = i+1; j < ip.length; j++) {
					if(a[j] > op) {
						op = a[j];
						break;
					}
				}
				
				if(op==a[i])
				{
					a[i] = -1;
				}
				else
				{
					a[i] = op;
				}
			}
			a[n-1]= -1;
			for (int i = 0; i < ip.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();*/
		}
	}
}
