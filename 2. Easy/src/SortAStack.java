import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
// https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

class SortAStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String arr[] = br.readLine().trim().split("\\s+");
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < n; i++) {
				s.push(Integer.parseInt(arr[i]));
			}
			s = sort(s);
			
			while(!s.isEmpty()) {
				System.out.print(s.pop()+" ");
			}
			System.out.println();
		}
	}
	
	static Stack<Integer> sort(Stack<Integer> s){
		if(s==null || s.isEmpty()) return s;
		Stack<Integer> tempStack = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			int topS = s.pop();
			while(!tempStack.isEmpty() && topS < tempStack.peek()) {
				s.push(tempStack.pop());
			}
			tempStack.push(topS);
		}
		return tempStack;
	}
	
	// my algo using two extra stack
	/*static Stack<Integer> sort(Stack<Integer> s){
		
		Stack<Integer> sortedStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		
		int min = Integer.MAX_VALUE;
		while(!s.isEmpty()) {
			while(!s.isEmpty()) {
				min = Math.min(min, s.peek());
				tempStack.push(s.pop());
			}

			sortedStack.push(min);
			
			while(!tempStack.isEmpty()) {
				if(tempStack.peek()==min) 	{
					tempStack.pop();
					min = Integer.MAX_VALUE;
				}
				else 	s.push(tempStack.pop());
			}
		}
		return sortedStack;
	}*/
}
