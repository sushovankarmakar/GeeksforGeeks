import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://practice.geeksforgeeks.org/editorial.php?pid=700453

class SpecialStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine().trim());
			String arr[] = br.readLine().trim().split("\\s+");
			Stack<Integer> st = new Stack<>();
			
			for (int i = 0; i < n; i++) {
				st.push(Integer.parseInt(arr[i]));
			}
			
			System.out.println(min(st));
		}
	}
	
	static void push(int a,Stack<Integer> s)
	{
	    s.push(a);
	}
	
	static int pop(Stack<Integer> s)
    {
        return s.pop();
	}
	
	static int min(Stack<Integer> s)
    {
        int min = Integer.MAX_VALUE;
        
        while(!s.isEmpty()) {
            int num  = s.pop();
            min = Math.min(min, num);
        }
        return min;
	}
	
	static boolean isFull(Stack<Integer>s, int n)
    {
        if( s.size()== n ) return true;
        else return false;
	}
	
	static boolean isEmpty(Stack<Integer>s)
    {
           return s.isEmpty();
	}
}
