import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class GeekTheBuilderJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			ArrayList<Integer> arr = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(ip[i]));
			}
			builder(arr);
			System.out.println();
		}
	}
	
	static void builder(ArrayList<Integer>arr)
    {
       int min = Integer.MAX_VALUE;
       for(Integer a: arr){
           
           if(a <= min) {
               min = a;
           }
           System.out.print(min+" ");
       }
    }
}
