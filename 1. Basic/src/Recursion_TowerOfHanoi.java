import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
// https://practice.geeksforgeeks.org/problems/help-the-old-man/0
// https://www.freecodecamp.org/news/analyzing-the-algorithm-to-solve-the-tower-of-hanoi-problem-686685f032e3/ (awesome explanation)
// https://ide.geeksforgeeks.org/aU4tEG


public class Recursion_TowerOfHanoi {
    private static void towerOfHanoi(int plates, int from, int to, int aux) {
        if(plates == 0) {   // if no plates, simply return. this is the breaking condition
            return;
        }
        towerOfHanoi(plates-1, from, aux, to);  // shift n-1 disk from 'from' rod to 'aux' rod

        totalMoves++;                           // shift last disk from 'from' rod to 'to' rod
        if(totalMoves == expectedMoveNo) {
            System.out.println(from + " " + to);
        }
        towerOfHanoi(plates-1, aux, to, from);  // shift n-1 disk from 'aux' rod to 'to' rod
    }

    static int totalMoves = 0, expectedMoveNo = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] Nn = br.readLine().trim().split("\\s+");
            int plates = Integer.parseInt(Nn[0]);
            expectedMoveNo = Integer.parseInt(Nn[1]);
            towerOfHanoi(plates, 1, 3, 2);
            totalMoves = 0;
        }
    }
}


// programme for printing all the steps in tower of hanoi

/*

public class TowerOfHanoi {
    ArrayList<String> towerOfHanoi(int n) {
        ArrayList<String> list = new ArrayList<String>();
        towersOfHanoi(list, n, 'A', 'C', 'B');
        return list;
    }

    private static void towersOfHanoi(ArrayList<String> list, int n, char from, char to, char aux) {
        if(n == 1) {
            list.add("1" + " "+ from + " " + to);
            return;
        }
        towersOfHanoi(list, n-1, from, aux, to);    // shift n-1 disk from A to B
        list.add(n +" "+ from +" "+ to);            // shift last disk from A to C
        towersOfHanoi(list, n-1, aux, to, from);    // shift n-1 disk from B to C
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> result = new TowerOfHanoi().towerOfHanoi(n);
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
}

*/

