import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


class JavaCollectionHashMap2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int q = Integer.parseInt(br.readLine().trim());
			while(q-->0) {
				char c = br.readLine().trim().charAt(0);
				if(c=='a') {
					String ip[] = br.readLine().trim().split("\\s+");
					int x = Integer.parseInt(ip[0]), y = Integer.parseInt(ip[1]);
					add_Value(hm,x,y);
				}
				else if(c=='b') {
					int y = Integer.parseInt(br.readLine().trim());
					System.out.println(find_value(hm,y)+" ");
				}
				else if(c=='c') {
					System.out.println(getSize(hm)+" ");
				}
				else if(c=='d') {
					int x = Integer.parseInt(br.readLine().trim());
					removeKey(hm, x);
				}
			}
			System.out.println();
		}
	}
	
	/*Inserts an entry with key x and value y in map */
    static void add_Value(HashMap<Integer,Integer> hm, int x, int y)
    {
    	hm.put(x, y);
    }
	
    /*Returns the value with key x from the map */
    static int find_value(HashMap<Integer, Integer> hm, int x)
    {
        if(hm.containsKey(x)) {
        	return hm.get(x);
        }
    	return -1;
    }
	
    /*Returns the size of the map */
    static int getSize(HashMap<Integer, Integer> hm)
    {
    	return hm.size();
    }
		
    /*Removes the entry with key x from the map */	
    static void removeKey(HashMap<Integer, Integer> hm, int x)
    {
    	hm.remove(x);	
    }
}
