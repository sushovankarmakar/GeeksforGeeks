import java.util.Scanner;

// https://www.geeksforgeeks.org/game-nim-removal-one-stone-allowed/

class WinnerOfGameOfNim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			System.out.println((n%2!=0)?"Player A":"Player B");
		}
		sc.close();
	}
}
