import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
// https://practice.geeksforgeeks.org/problems/pascal-triangle0652/1
// https://www.youtube.com/watch?v=6FLvhQjZqvM (This explains all the 3 approaches)
// https://www.youtube.com/watch?v=7pOzP9m_bX8&ab_channel=TerribleWhiteboard

public class Arrays_PascalsTriangle {

    private static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if (numRows == 0) return pascalTriangle;

        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = pascalTriangle.get(rowNum - 1);
            currRow.add(1);

            for (int i = 0; i < prevRow.size() - 1; i++) {

                /* we take two each number and it's next number of previous rows and add them to get the current number */

                int numA = prevRow.get(i);
                int numB = prevRow.get(i + 1);
                currRow.add(numA + numB);
            }
            currRow.add(1);
            pascalTriangle.add(currRow);
        }
        return pascalTriangle;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int numRows = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> output = generatePascalsTriangle(numRows);
            print(output);
        }
    }

    private static void print(List<List<Integer>> output) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output.size(); i++) {
            sb.append("[ ");
            for (int j = 0; j < output.get(i).size(); j++) {
                sb.append(output.get(i).get(j)).append(" ");
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
        sb.setLength(0);
    }
}
