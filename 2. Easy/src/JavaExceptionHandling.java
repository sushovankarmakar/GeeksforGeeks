import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class JavaExceptionHandling {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
			FindMinimumTestClass ob = new FindMinimumTestClass(a,b);
			ob.findMin();
		}
	}
}

class FindMinimumTestClass{
	int a,b,min=Integer.MAX_VALUE;
	int ans[] = new int[4];
	public FindMinimumTestClass(int x,int y) {
		a = x;
		b = y;
	}
	void findMin(){
		try {
			ans[0] = a+b; ans[1] = a-b; ans[2] = a*b; ans[3] = a/b;
			for (int i = 0; i < 4; i++) {
				if(min > ans[i]) {
					min = ans[i];
				}
			}
		}catch(Exception e) {
			for (int i = 0; i < 3; i++) {
				if(min > ans[i]) {
					min = ans[i];
				}
			}
		}
		System.out.println(min);
	}
}
