import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/trie-insert-and-search/0
// https://practice.geeksforgeeks.org/problems/trie-delete/1
// https://www.youtube.com/watch?v=AXjmTQ8LEoI (BEST video explanation)
// https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java

public class Trie_InsertSearchDelete {

    private static TrieNode rootNode;

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;
        TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private static void insert(String word) {
        TrieNode currentNode = rootNode;
        for (char ch : word.toCharArray()) {
            TrieNode nextNode = currentNode.children.get(ch);
            if(nextNode == null) {
                nextNode = new TrieNode();
                currentNode.children.put(ch, nextNode);
            }
            currentNode = nextNode;
        }
        currentNode.isEndOfWord = true; // it indicates that this word is ended here.
    }

    private static boolean search(String wordToBeSearched) {
        TrieNode currentNode = rootNode;
        for (char ch : wordToBeSearched.toCharArray()) {
            TrieNode nextNode = currentNode.children.get(ch);

            /*if nextNode doesn't exist, then this character is not exists also,
            so here is a mismatch so return false*/
            if(nextNode == null) {
                return false;
            }
            currentNode = nextNode;
        }
        return currentNode.isEndOfWord; // return true if currentNode's isEndOfWord is true, otherwise return false
    }

    private static boolean delete(String wordToBeDeleted) {
        return delete(rootNode, wordToBeDeleted, 0);
    }

    private static boolean delete(TrieNode currentNode, String wordToBeDeleted, int index) {

        if(index == wordToBeDeleted.length()) {

            /*if currentNode's isEndOfWord is false, then it's not the end of the word
            so it's not possible to delete, so return false*/
            if(!currentNode.isEndOfWord) {
                return false;
            }

            /*we have found the word entirely, so before deleting, setting isEndOfWord false
            if later we try to find the deleted word, we won't get*/
            currentNode.isEndOfWord = false;

            /*if the currentNode has no other mapping, then return true.
            this gives the indication to the calling function that
            they can delete this reference from their map*/
            return currentNode.children.size() == 0;
        }

        char ch = wordToBeDeleted.charAt(index);
        TrieNode nextNode = currentNode.children.get(ch);

        /*if nextNode doesn't exist, then this character is not exists also,
        so here is a mismatch so return false*/
        if(nextNode == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(nextNode, wordToBeDeleted, index + 1);

        /*if shouldDeleteCurrentNode is true then
        delete the mapping of character and trieNode reference from the map*/
        if(shouldDeleteCurrentNode) {
            currentNode.children.remove(ch);

            return currentNode.children.size() == 0;    // return true if no mapping is left in the map
        }
        return false;
    }

    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] words = br.readLine().trim().split("\\s+");
            rootNode = new TrieNode();
            for (String word : words) {
                insert(word);
            }

            String wordToBeSearched = br.readLine().trim();
            System.out.println(search(wordToBeSearched) ? "1" : "0");

            String wordToBeDeleted = br.readLine().trim();
            System.out.println(delete(wordToBeDeleted)  ? "1" : "0");

            wordToBeSearched = br.readLine().trim();
            System.out.println(search(wordToBeSearched) ? "1" : "0");
        }
    }
}
