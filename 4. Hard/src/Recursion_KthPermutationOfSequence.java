import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.youtube.com/watch?v=W9SIlE2jhBQ (good video explanation)
// https://gist.github.com/SuryaPratapK/a64499da7bfd8f4e3d3c2dd744e9a904 (code)
// https://leetcode.com/problems/permutation-sequence/
// https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
// https://www.youtube.com/watch?v=knTd0fgAo-0
// https://www.geeksforgeeks.org/find-the-k-th-permutation-sequence-of-first-n-natural-numbers/

public class Recursion_KthPermutationOfSequence {

    private static String kthPermutation(int n , int k) {

        // The block size nth digit will be the factorial of n
        long[] factorials = getFactorials(n);
        List<Character> characters = getListOfCharacters(n);

        k = k-1;

        String op = "";
        for(int i=1; i<=n; i++) {
            long blockSize = factorials[n-i];
            int index = (int) (k/blockSize);

            op += characters.get(index);
            characters.remove(index);

            k = k - ((int) (index*blockSize));
        }
        return op;
    }

    private static long[] getFactorials(int n) {
        long[] factorials = new long[n+1];
        long fact = 1;
        factorials[0] = 1;
        for(int i = 1; i <= n ; i++) {
            fact *= i;
            factorials[i] = fact;
        }
        return factorials;
    }

    private static List<Character> getListOfCharacters(int n) {
        List<Character> characters = new ArrayList<>();
        for(int i = 0; i <n ; i++) {
            characters.add((char) (65 + i));
        }
        return characters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n , k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        String ans = kthPermutation(n , k);
        for(int i = 0 ; i < ans.length() ; i++) {
            System.out.print(ans.charAt(i));
        }
    }
}
