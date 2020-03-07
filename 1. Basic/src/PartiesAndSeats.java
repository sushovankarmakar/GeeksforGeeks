import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class PartiesAndSeats {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String parties[] = br.readLine().trim().split("\\s+"), seat[] = br.readLine().trim().split("\\s+");
			int seats[] = new int[n];
			for (int i = 0; i < n; i++) {
				seats[i] = Integer.parseInt(seat[i]);
			}
			election2019(parties, seats, n);
		}
	}
	
	static void election2019(String party[], int seats[], int n)
    {
        Map<String, Integer> map = new TreeMap<>();
        int highest = Integer.MIN_VALUE;
        for(int i = 0; i < party.length; i++){
            map.put(party[i], seats[i]);
            highest  = Math.max(highest,seats[i]);
        }
        
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue()); 
        }
        System.out.println(highest);
    }
}
