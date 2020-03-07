import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TheSpiderSteps {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int h = Integer.parseInt(ip[0]), u = Integer.parseInt(ip[1]), d = Integer.parseInt(ip[2]),
				climb = u-d , i=1 , rem= h - climb;
			while(u <= rem) {
				i++;
				climb += (u-d);
				//System.out.println("climb "+ climb);
				rem = h - climb;
			}
			System.out.println(i+1);
		}
	}
}

/*
2
200 50 1
*/