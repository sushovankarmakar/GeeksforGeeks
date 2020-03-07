import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


class JavaCollectionArrayList1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip1[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip1[0]), q = Integer.parseInt(ip1[1]), p = 0,r = 0;
			String ip2[] = br.readLine().trim().split("\\s+");
			ArrayList<Integer> arrlist = new ArrayList<>(); 
			for (int i = 0; i < n; i++) {
				arrlist.add(Integer.parseInt(ip2[i]));
			}
			if(q==1) {
				String ip3[] = br.readLine().trim().split("\\s+");
				p = Integer.parseInt(ip3[0]); 
				r = Integer.parseInt(ip3[1]);
				arrlist.add(p, r);
				System.out.println(arrlist.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
			}
			else if(q==2) {
				p = Integer.parseInt(br.readLine().trim());
				try {
					int pos = arrlist.lastIndexOf(p);  // getting the last index of value p.
					System.out.println(pos);
				}
				catch (Exception ex){
					System.out.println("-1");
				}
			}
		}
	}
}
