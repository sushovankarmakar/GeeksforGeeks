import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class RowWithMinNumOf1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
			int countOne = Integer.MAX_VALUE, row = -1;

			for (int i = 0; i < n; i++) {
				int count=0;
				for (int j = 0; j < m; j++) {
					if(Integer.parseInt(s2[(i*m)+j])==1) {
						count++;
					}
				}
				if(countOne > count && count!=0) {
					countOne = count;
					row = i;
				}
			}
			System.out.println(countOne==0?"-1":row);
		}
	}
}
