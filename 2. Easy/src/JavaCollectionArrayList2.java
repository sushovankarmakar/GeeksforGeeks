import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class JavaCollectionArrayList2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			ArrayList<Integer> A = new ArrayList<>();
			int q = Integer.parseInt(br.readLine());  // number of queries
			
			while(q-->0) {
				 char c = br.readLine().charAt(0);
				 if(c=='a') {
					 int x = Integer.parseInt(br.readLine());
					 add_to_ArrayList(A,x);
				 }
				 else if(c=='b') sort_ArrayList_Asc(A);
				 else if(c=='c') reverse_ArrayList(A);
				 else if(c=='d') System.out.print(size_Of_ArrayList(A)+" ");
				 else if(c=='e') print_ArrayList(A);
				 else if(c=='f') sort_ArrayList_Desc(A);
			}
			System.out.println();
		}
	}

	/*inserts an element x at the back of the ArrayList A */
	static void add_to_ArrayList(ArrayList<Integer> A, int x) {
		A.add(x);
	}
	
	/*sort the ArrayList A in ascending order*/
	static void sort_ArrayList_Asc(ArrayList<Integer> A) {
		Collections.sort(A);
    }
	
    /*reverses the ArrayList A*/
    static void reverse_ArrayList(ArrayList<Integer> A) { 
    	Collections.reverse(A);
    }
	
    /*returns the size of the ArrayList A */
    static int size_Of_ArrayList(ArrayList<Integer> A) {
    	return A.size();
    }
	
    /*prints space separated elements of ArrayList A*/
    static void print_ArrayList(ArrayList<Integer> A) {
    	System.out.print(A.toString().replaceAll(",", "").replace("[", "").replace("]", "")+" ");
    }
    
    /*sorts the ArrayList A in descending order*/
    static void sort_ArrayList_Desc(ArrayList<Integer> A)
    {
    	Collections.sort(A, Collections.reverseOrder());
    }
}

