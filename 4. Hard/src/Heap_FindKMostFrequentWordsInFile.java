import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/ (best explanation)
// https://stackoverflow.com/questions/185697/the-most-efficient-way-to-find-top-k-frequent-words-in-a-big-word-sequence

public class Heap_FindKMostFrequentWordsInFile {
    public static List<String> frequentWords(List<String> vec,int k) {
        // store the frequency of each words
        Map<String, Integer> frequencyMap = getFrequencyOfWords(vec);

        // get K most frequently words in min heap
        Queue<String> minHeap = getKMostFrequentlyWords(frequencyMap, k);

        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }
        return result;
    }

    private static Map<String, Integer> getFrequencyOfWords(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    private static Queue<String> getKMostFrequentlyWords(Map<String, Integer> map, int k) {
        Queue<String> minHeap = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2)
        );

        for(String word : map.keySet()) {
            minHeap.add(word);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(sc.next());
        int k=sc.nextInt();
        List<String> ans = frequentWords(list, k);
        for(int i=0;i<k;i++)
            System.out.println(ans.get(i));
    }
}
