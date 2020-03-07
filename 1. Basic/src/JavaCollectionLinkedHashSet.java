import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;


class JavaCollectionLinkedHashSet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			LinkedHashSet<Integer> s = new LinkedHashSet<>();
			int q  = Integer.parseInt(br.readLine().trim());
			while(q-->0) {
				char c = br.readLine().trim().charAt(0);
				if(c=='a') {
					int x  = Integer.parseInt(br.readLine().trim());
					insert(s, x);
				}
				else if(c=='b') {
					print_Contents_Increasing_Order(s);
				}
				else if(c=='c') {
					int x  = Integer.parseInt(br.readLine().trim());
					erase(s, x);
				}
				else if(c=='d') {
					int x  = Integer.parseInt(br.readLine().trim());
					find(s, x);
				}
				else if(c=='e') {
					System.out.print(size(s)+" ");
				}
				else if(c=='f') {
					print_Contents_Insertion_Order(s);
				}
			}
			System.out.println();
		}
	}
	
	
	/*inserts an element x to the set s */
    static void insert(LinkedHashSet<Integer> s, int x)
    {
    	s.add(x);
    }
	
    /*prints the contents of the set s in ascending order */
    static void print_Contents_Increasing_Order(LinkedHashSet<Integer> s)
    {
    	if(!s.isEmpty()) {
    		List<Integer> l = new ArrayList<>();
        	l.addAll(s);
        	Collections.sort(l);
        	System.out.print(l.toString().replaceAll(",", "").replace("[", "").replace("]", "")+" ");
    	}
    }
     /*prints the contents of the set s in ascending order */
    static void print_Contents_Insertion_Order(LinkedHashSet<Integer> s)
    {
		if(!s.isEmpty()) {
			System.out.print(s.toString().replaceAll(",", "").replace("[", "").replace("]", "")+" ");
		}
    	
    }
	
    /*erases an element x from the set s */	
    static void erase(LinkedHashSet<Integer> s, int x)
    {
    	s.remove(x);
    }
	
    /*returns the size of the set s */
    static int size(LinkedHashSet<Integer> s)
    {
        return s.size();
    }
		
    /*returns 1 if the element x is present in set s else returns -1 */
    static int find(LinkedHashSet<Integer> s, int x)
    {
    	if(s.contains(x)) {
    		return 1;
    	}
    	return -1;
    }
}
