import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


class JavaCollectionTreeMap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();
			int q = Integer.parseInt(br.readLine().trim());
			while(q-->0) {
				char c = br.readLine().trim().charAt(0);
				if(c=='a') {
					int x = Integer.parseInt(br.readLine().trim());
					int y = Integer.parseInt(br.readLine().trim());
					add_Value(hm, x, y);
				}
				else if(c=='b') {
					int y = Integer.parseInt(br.readLine().trim());
					System.out.println(find_value(hm, y)+" ");
				}
				else if(c=='c') {
					System.out.println(getSize(hm)+" ");
				}
				else if(c=='d') {
					int x = Integer.parseInt(br.readLine().trim());
					removeKey(hm, x);
				}
				else if(c=='e') {
					sorted_By_Key(hm);
				}
			}
		System.out.println();
		}
	}
	
	/*Inserts an entry with key x and value y in map */
	static void add_Value(TreeMap<Integer,Integer> hm, int x, int y)
    {
		hm.put(x, y);
    }
	
    /*Returns the value with key x from the map */
    static int find_value(TreeMap<Integer, Integer> hm, int x)
    {
        if(hm.containsKey(x)) {
        	return hm.get(x);
        }
        return -1;
    }
	
    /*Returns the size of the map */
    static int getSize(TreeMap<Integer, Integer> hm)
    {
    	return hm.size();
    }
		
    /*Removes the entry with key x from the map */	
    static void removeKey(TreeMap<Integer, Integer> hm, int x)
    {
    	hm.remove(x);	
    }
    
    /*print map sorted by key */	
    static void sorted_By_Key(TreeMap<Integer, Integer> hm)
    {
    	System.out.print(hm.keySet().toString().replaceAll(",", "").replace("[", "").replace("]", "")+" ");
    }   
}
