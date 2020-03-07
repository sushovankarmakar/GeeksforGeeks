import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/contest-problem/pattern-printer-java/1/

class PatternPrinterJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			char[] ch = br.readLine().trim().toCharArray();
			Queue<Character> q = new LinkedList<>();
			for (int i = 0; i < ch.length; i++) {
				q.add(ch[i]);
			}
			
			// solving it through Deque
			Deque<Character> dq = new LinkedList<Character>();
		    while(q.size() > 0){
		    	dq.addLast(q.remove());
		    }
		       
		    while(dq.size() > 0 ){
	           
	           if(dq.peekFirst()!=null){
	             System.out.print( dq.pollFirst() );  
	           }
	           if(dq.peekLast()!=null){
	             System.out.print( dq.pollLast() );  
	           }
		    }
		}
	}
}

/*if size of queue is odd then dequeue elements from queue upto size()/2(inclusive) and enqueue it, 
 * do the same with stack also i.e. remove from queue and push into stack less than size()/2
	then print elements from queue and stack alternatively, keeping check that both are not empty
	
	else if size of queue is even then dequeue elements from queue upto size()/2(exclusive) 
	and enqueue it, do the same with stack also i.e. remove from queue and push into stack before size()/2
	then print elements from queue and stack alternatively, keeping check that both are not empty*/

/*static void patternPrint(Queue<Character>q)
{
    if(q.size()%2!=0)
    {
        for(int i=0;i<=q.size()/2;i++)
        {
            q.add(q.poll());
            
        }
        Stack<Character>s=new Stack<>();
        int q_len=q.size()/2;
        for(int i=0;i<q_len;i++)
        {
            s.push(q.poll());
           
        }
        // System.out.println(s);
        // System.out.println(q);
        
        while(!s.isEmpty()&&!q.isEmpty())
        {
            System.out.print(q.poll());
            
            System.out.print(s.peek());
            s.pop();
        }
         while(!s.isEmpty())
        {
          
            System.out.print(s.peek());
            s.pop();
        }
        while(!q.isEmpty())
        {
            System.out.print(q.peek());
            q.poll();
            
        }
    }
    else{
         for(int i=0;i<q.size()/2;i++)
        {
            q.add(q.poll());
            
        }
        Stack<Character>s=new Stack<>();
        int q_len=q.size()/2;
        for(int i=0;i<q_len;i++)
        {
            s.push(q.poll());
           
        }
        // System.out.println(s);
        // System.out.println(q);
        
        while(!s.isEmpty()&&!q.isEmpty())
        {
            System.out.print(q.poll());
            
            System.out.print(s.peek());
            s.pop();
        }
         while(!s.isEmpty())
        {
          
            System.out.print(s.peek());
            s.pop();
        }
        while(!q.isEmpty())
        {
            System.out.print(q.peek());
            q.poll();
            
        }
        
        
    }   
}*/

