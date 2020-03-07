import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class JavaCollectionsQueue {

	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			while(n-->0) {
				char c = br.readLine().trim().charAt(0);
				if(c=='a') {
					int k = Integer.parseInt(br.readLine().trim());
					addElement(k);
				}
				else if(c=='r') {
					RemoveElement();
				}
				else if(c=='p') {
					peekElement();
				}
				else {
					Size();
				}
			}
			System.out.println();
			q.clear();
		}
	}
	
	static void addElement(int key)
    {
        q.add(key);
    }
    static void RemoveElement()
    {
    	if(!q.isEmpty()) {
        	System.out.print(q.remove()+" ");
        }
        else {
        	System.out.print("-1 ");
        }
    }
    static void peekElement()
    {
        if(!q.isEmpty()) {
        	System.out.print(q.peek()+" ");
        }
        else {
        	System.out.print("-1 ");
        }
    }
    static void Size()
    {
        System.out.print(q.size()+" ");
    }
}
