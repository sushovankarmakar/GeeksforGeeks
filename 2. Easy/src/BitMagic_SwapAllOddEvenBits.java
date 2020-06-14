import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits/0
// https://www.geeksforgeeks.org/swap-all-odd-and-even-bits/

/*
  Time Complexity: O(1), the time needed is constant since we iterate
        through the same sized integer irrespective of its value.
  Space Complexity: O(1)
  1. Isolate even bit values by doing AND of input with 0xAAAAAAAA,
        which has all even bits set to 1. Right shift this by 1 bit.
  2. Isolate odd bit values by doing AND of input with 0x55555555,
        which has all odd bits set to 1. Left shift this by 1 bit.
  3. OR the above 2 values to combine them.
*/

// https://www.youtube.com/watch?v=PHH41vjQXrQ (A good animated explanation)
// https://www.youtube.com/watch?v=AVWaH9bzeYc
// https://www.youtube.com/watch?v=GWLCF808oVI

public class BitMagic_SwapAllOddEvenBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());

            int evenBits = n & 0xAAAAAAAA;  // extracting the even bits
            int oddBits  = n & 0x55555555;  // extracting the odd bits

            int swappedValue = (evenBits >> 1) | (oddBits << 1) ;

            System.out.println(swappedValue);
        }
    }
}
