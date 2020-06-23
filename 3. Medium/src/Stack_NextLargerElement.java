import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/next-larger-element/0

// https://www.youtube.com/watch?v=8P-Z7Oc8x9I
// https://www.youtube.com/watch?v=sDKpIO2HGq0 (store the indices to print in same order as input)
// https://www.youtube.com/watch?v=R2o2zUuu3ss

// https://www.geeksforgeeks.org/next-greater-element-in-same-order-as-input/
class Stack_NextLargerElement {

	// The benefit is that when we arrive at a certain index his next greater element will be already in stack
	// and we can directly get this element while at the same index.

	private static long[] findNextGreaterElement(long[] ip, int n) {
		long[] op = new long[n];
		Stack<Long> stack = new Stack<>();

		for(int i = n-1; i >= 0; i--) {
			// keep popping until the top of stack is not greater than the current value
			while(!stack.isEmpty() && stack.peek() <= ip[i]) {
				stack.pop();
			}
			op[i] = (stack.isEmpty()) ? -1 : stack.peek();

			stack.push(ip[i]);
		}
		stack.clear();
		return op;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().trim().split("\\s+");
			long[] ip = new long[n];
			for(int i = 0; i < n; i++) {
				ip[i] = Long.parseLong(str[i]);
			}
			
			// Approach-3; this approach print the output in the same order as input
			long[] op = findNextGreaterElement(ip,n);
			print(op, n);
		}
	}

	private static void print(long[] ip, int n) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sb.append(ip[i] + " ");
		}
		System.out.println(sb);
	}
}


// -------------------------------------------------------------------------------------------

// https://www.youtube.com/watch?v=sDKpIO2HGq0 (store the indices to print in same order as input)

/*
// in stack, we will store the indices of the actual input.

	private static long[] findNextGreaterElement(long[] ip, int n) {
		long[] nge = new long[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for(int i = 1; i < n; i++) {
			long num = ip[i];

			while(!stack.isEmpty() && ip[stack.peek()] < num ) {
				nge[stack.pop()] = num;
			}
			stack.push(i);
		}

		while(!stack.isEmpty()) {
			nge[stack.pop()] = -1;
		}

		return nge;
	}

	private static void print(long[] ip, int n) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sb.append(ip[i] + " ");
		}
		System.out.println(sb);
	}
	*/


// -------------------------------------------------------------------------------------------


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


// -------------------------------------------------------------------------------------------

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
