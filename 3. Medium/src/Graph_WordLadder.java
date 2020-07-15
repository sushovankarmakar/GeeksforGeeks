import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/word-ladder/1
// https://leetcode.com/problems/word-ladder/
// https://leetcode.com/problems/word-ladder/solution/
// https://www.youtube.com/watch?v=O3hUyXyHeBw&t=72s (Best Video Explanation)
// https://www.youtube.com/watch?v=M9cVl4d0v04

public class Graph_WordLadder {

    // --------------------------------------------------------------------------------------------------------------
    // APPROACH-1
    // time complexity : O(n*n*k) where n = number of words, k = length of largest word
    // space complexity : O(n)  where n is the queue size

    private static class Pair {
        String word;
        int len;
        Pair(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    private static int getLengthOfWordLadder(String startWord, String targetWord, Set<String> dictionary) {
        if(startWord.length() == 0 || targetWord.length() == 0 || dictionary.isEmpty() || !dictionary.contains(targetWord))
            return 0;

        //int length = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();

            // we need to use iterator cause we need to traverse the dictionary along updating the dictionary
            Iterator<String> itr = dictionary.iterator();
            while (itr.hasNext()) {
                String nextWord = itr.next();
                if (isAdjacentWord(currentPair.word, nextWord)) {
                    if(nextWord.equalsIgnoreCase(targetWord)) return currentPair.len + 1;

                    itr.remove();   // move the current adjacent word from dictionary cause we'll consume it
                    queue.add(new Pair(nextWord, currentPair.len + 1));
                }
            }
            //length++; // updating length separately is very confusing. It is easy to use Pair class.
        }
        return 0;
    }

    private static boolean isAdjacentWord(String wordA, String wordB) {
        int difference = 0;
        for (int i = 0; i < wordA.length(); i++) {
            if(wordA.charAt(i) != wordB.charAt(i)) {
                difference++;
                if(difference > 1) return false;
            }
        }
        return true;
    }

    // --------------------------------------------------------------------------------------------------------------
    // APPROACH-2
    private static int getWordLadderLength(String startWord, String targetWord, Set<String> dictionary) {
        if(startWord.length() == 0 || targetWord.length() == 0 || dictionary.isEmpty() || !dictionary.contains(targetWord))
            return 0;

        return bfs(startWord, targetWord, dictionary);
    }

    private static int bfs(String startWord, String targetWord, Set<String> dictionary) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) { // it is bfs, so traverse for all the words in this same level
                char[] currWord = Objects.requireNonNull(queue.poll()).toCharArray();

                // traverse current word, change each character and check it becomes target word or not
                for (int j = 0; j < currWord.length; j++) {

                    char tempChar = currWord[j];
                    if(isTargetWordFound(currWord, j, queue, targetWord, dictionary)) return length + 1;

                    currWord[j] = tempChar; // have to undo for next change of letter
                }
            }
            length++;   // this level ends with one letter changed.
        }
        return 0;
    }

    private static boolean isTargetWordFound(char[] currWord, int pos, Queue<String> queue, String targetWord,
                                             Set<String> dictionary) {
        // change one letter at a time at this position and check if that is targetWord or not

        for (char ch = 'a'; ch <= 'z'; ch++) {
            currWord[pos] = ch;
            String nextWord = new String(currWord);

            if(dictionary.contains(nextWord)) {
                if(nextWord.equalsIgnoreCase(targetWord)) return true;

                /*when nextWord in the set but that is not target word,
                it is added to queue for next round
                and remove from dictionary so that we don't check it further*/

                queue.offer(nextWord);
                dictionary.remove(nextWord);
            }
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine().trim();
            }
            String startWord = br.readLine().trim();
            String targetWord = br.readLine().trim();
            Set<String> dictionary = getTheDictionary(words);
            System.out.println(getLengthOfWordLadder(startWord, targetWord, dictionary));   // APPROACH-1
            //System.out.println(getWordLadderLength(startWord, targetWord, dictionary));   // APPROACH-2
        }
    }

    private static Set<String> getTheDictionary(String[] words) {
        Set<String> dictionary = new HashSet<>();
        Collections.addAll(dictionary, words);
        return dictionary;
    }
}
