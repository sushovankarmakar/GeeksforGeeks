import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/regular-expression-matching/
// https://www.youtube.com/watch?v=l3hda49XcDE (BEST VIDEO  <- I followed this)
// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/RegexMatching.java

public class DP_RegularExpressionMatching {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String pattern = br.readLine().trim();
            System.out.println(isRegExMatch(text, pattern));
        }
    }

    /*i-th value represents every character of the text*/
    /*j-th value represents every character of the pattern*/
    /*if mat[i][j] true means till i-th value in text and till j-th value in the pattern everything has been matched so far*/
    /*a pattern starts with '*' is invalid pattern. example: *abc , *.  */

    /* pattern : xa*b.c
       text    : xaabyc
       output  : true
    */

    /*    0 1 2 3 4 5 6
    *       x a * b . c
      0   T F F F F F F
      1 x F T F T F F F
      2 a F F T T F F F
      3 a F F F T F F F
      4 b F F F F T F F
      5 y F F F F F T F
      6 c F F F F F F T
    * */

    private static boolean isRegExMatch(String text, String pattern) {

        /*if question allows pattern with leading '*', then we need to remove those '*' first */
        //pattern = getOptimizedPattern(pattern);

        /* if pattern or text is null or if a pattern starts with '*', then we that is an invalid pattern,
        in all these cases, return false */
        if(pattern == null || text == null || pattern.charAt(0) == '*') return false;

        boolean[][] mat = new boolean[text.length() + 1][pattern.length() + 1];

        /*1. M[0][0] = true, since empty string matches empty pattern*/
        mat[0][0] = true;   /*if we have an empty string and an empty pattern then it is matched here, so it is true*/

        /*if we have empty pattern and text is non-empty then it is not RegEx match so 0th column is false*/

        /*filling up the 0th row, if pattern is like this : a* or a*b* or a*b*c*, then we have true value in 0th row*/
        for (int j = 1; j < mat[0].length; j++) {
            if(pattern.charAt(j - 1) == '*') {
                mat[0][j] = mat[0][j - 2];
            }
        }

        /* '*' matches zero or more occurrences of character before '*' */
        /* '.' matches any single character */
        /*In the matrix representation, index of text and index of pattern starts from 1, instead of 0 */

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {

                /*if current text character and pattern character matches or pattern character is '.' then
                copy the upper left corner value of the matrix which represents the so far matched value*/
                if(text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    mat[i][j] =  mat[i - 1][j - 1];
                }
                else if(pattern.charAt(j - 1) == '*') {  /* '*' matches zero or more occurrences of character before '*' */

                    /*check for zero occurrences of the value which is before the '*' */
                    mat[i][j] = mat[i][j - 2];  /*stay on the same row and move two back in column, copy that value*/


                    /*MOST IMPORTANT LOGIC*/
                    /*check 11th minute of Tushar Roy's video for clarification with more example*/

                    /*  x a *
                      x
                      a <- this 'a' can be seen as a part of 'a *'
                    */

                    /*check for one or more occurrences of the value which is before the '*' */
                    /*if the character before '*' matches with current character, we can see current character as part of it*/
                    if(text.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                        mat[i][j] = mat[i][j] | mat[i - 1][j];     /*choose between the value at current position or the top position*/
                    }

                    /* explanation of this line: mat[i][j] = mat[i][j] | mat[i - 1][j]

                    That's because there maybe conditions where 0 occurrences scenario is true hence setting T[i][j] as true.
                    After that, checking for 1 or more occurrences is not required.
                    If T[i][j] is already true due to 0 occurrences scenario,
                    here in the code he is doing OR operation to retain the true value of T[i][j]
                    irrespective of the result of check of 1 occurrences or more.*/
                }
                else {
                    mat[i][j] = false;
                }
            }
        }

        return mat[text.length()][pattern.length()];  // last cell of the matrix holds the final answer
    }

    /*removes the leading '*' from a pattern */
    /*private static String getOptimizedPattern(String pattern) {
        int index ;
        for (index = 0; index < pattern.length(); index++) {
            if(pattern.charAt(index) != '*') break;
        }
        return pattern.substring(index);
    }*/
}
