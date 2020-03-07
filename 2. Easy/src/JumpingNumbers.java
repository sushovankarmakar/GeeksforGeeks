import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class JumpingNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = 0;
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i <= 9; i++) {
				bfs(n,m,i);
			}
			System.out.println();
		}
	}
	
	public static void bfs(int n,int m,int num) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		
		while(!q.isEmpty()) {
			
			int stepNum = q.poll();
			
			if(stepNum <=m && stepNum >=n) {
				System.out.print(stepNum+" ");
			}
			
			if(stepNum==0 || stepNum > m) continue ;
			
			int lastDigit = stepNum % 10 ;
			int stepNumA = stepNum*10 + (lastDigit-1);
			int stepNumB = stepNum*10 + (lastDigit+1);
			
			if(lastDigit==0) {  
				q.add(stepNumB);
			}
			else if(lastDigit==9) {
				q.add(stepNumA);
			}
			else {
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
	}
}








/*public static void dfs(int n,int m,int stepNum) {
if(stepNum <=m && stepNum >=n) {
	System.out.print(stepNum+" ");
}

if(stepNum==0 || stepNum > m) return ;

int lastDigit = stepNum % 10 ;
int stepNumA = stepNum*10 + (lastDigit-1);
int stepNumB = stepNum*10 + (lastDigit+1);

if(lastDigit==0) {  
	dfs(n, m, stepNumB);
}
else if(lastDigit==9) {
	dfs(n, m, stepNumA);
}
else {
	dfs(n, m, stepNumA);
	dfs(n, m, stepNumB);
}
}*/
