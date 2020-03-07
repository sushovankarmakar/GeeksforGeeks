import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PerfectCubes_in_a_Range {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int i = 1, sq = 1;
			boolean isCube = false;
			while(sq <= b) {
				
				if(a<=sq && sq<=b)  {
					isCube = true;
					System.out.print(sq+" ");
				}
				
				i++;
				sq = i*i*i;
			}
			if(!isCube) System.out.print("No");
			System.out.println();
		}
	}
}
