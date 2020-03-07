import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class JavaCollection_Set {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			Set<Integer> s = new HashSet<Integer>();
			int q = Integer.parseInt(br.readLine());
			while(q-->0) {
				char c = br.readLine().trim().charAt(0);
				if(c=='a') {
					int x = Integer.parseInt(br.readLine().trim());
					insert(s, x);
				}
				else if(c=='b') {
					print_contents(s);
				}
				else if(c=='c') {
					int x = Integer.parseInt(br.readLine().trim());
					erase(s,x);
				}
				else if(c=='d') {
					int x = Integer.parseInt(br.readLine().trim());
					System.out.print(find(s,x)+" ");
				}
				else if(c=='e') {
					System.out.print(size(s)+" ");
				}
			}
			System.out.println();
		}
	}
	
	/*inserts an element x to the set s */
    static void insert(Set<Integer> s, int x)
    {
		s.add(x);
    }
	
    /*prints the contents of the set s in ascending order */
    static void print_contents(Set<Integer> s)
    {
    	if(!s.isEmpty()) {
    		//converting set to list
        	List<Integer> list = new ArrayList<>();
        	list.addAll(s);
        	Collections.sort(list);
        	System.out.print(list.toString().replaceAll(",", "").replace("[", "").replace("]", "")+" ");
    	}
    }
	
    /*erases an element x from the set s */	
    static void erase(Set<Integer> s, int x)
    {
		s.remove(x);
    }
	
    /*returns the size of the set s */
    static int size(Set<Integer> s)
    {
        return s.size();
    }
		
    /*returns 1 if the element x is present in set s else returns -1 */
    static int find(Set<Integer> s, int x)
    {
    	if(s.contains(x)) {
    		return 1;
    	}
    	return -1;	
    }
}
