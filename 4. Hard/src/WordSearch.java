import java.util.Scanner;

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) &&
                        searchTheWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchTheWord(char[][] board, int row, int col, String word, int index)
    {
        if(index == word.length()-1) {
            return true;
        }

        if(!isValidMove(board, row, col, word, index)) {
            return false;
        }

        board[row][col] = '#';

        boolean isFound =
                searchTheWord(board, row-1, col, word, index+1) ||  //searching on upper side
                        searchTheWord(board, row, col+1, word, index+1) ||  //searching on right side
                        searchTheWord(board, row+1, col, word, index+1) ||  //searching on lower side
                        searchTheWord(board, row, col-1, word, index+1);   //searching on left side

        board[row][col] = word.charAt(index);
        return isFound;
    }

    private boolean isValidMove(char[][] board, int row, int col, String word, int index) {
        return isValidCell(board, row, col) &&
                isMatchingChar(board, row, col, word, index);
    }

    private boolean isValidCell(char[][] board, int row, int col) {
        return (0 <= row && row < board.length) && (0 <= col && col < board[row].length);
    }

    private boolean isMatchingChar(char[][] board, int row, int col, String word, int index) {
        return (index < word.length()) && (board[row][col] == word.charAt(index));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char board[][] = new char [row][col];
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col;  j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        String word = scanner.next();
        scanner.close();
        boolean result = new WordSearch().exist(board , word);
        System.out.println(result);
    }
}
