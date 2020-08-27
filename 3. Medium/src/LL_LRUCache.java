import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/lru-cache/1
// https://www.youtube.com/watch?v=S6IfqDXWa10 (BEST Video explanation)
// https://leetcode.com/problems/lru-cache/
// https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java
// https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)

public class LL_LRUCache {

    private static class LRUCache {

        private final Map<Integer, ListNode> map = new HashMap<>();
        private final ListNode head;
        private final ListNode tail;
        private int totalItemInCache;
        private final int maxCapacity;

        public LRUCache(int capacity) {
            this.maxCapacity = capacity;    /* Cache starts empty and capacity is set by client */
            this.totalItemInCache = 0;

            this.head = new ListNode();     /* Dummy head and tail nodes to avoid empty states */
            this.tail = new ListNode();

            this.head.next = tail;  /* Wire the head and tail together */
            this.tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);

            if (node == null) {
                return -1;
            }
            moveToHead(node);   /* Item has been accessed. Move to the front of the cache */
            return node.value;
        }

        public void put(int key, int value) {
            ListNode node = map.get(key);

            if (node == null) { /* Item not found, create a new entry */
                node = new ListNode();
                node.key = key;
                node.value = value;

                map.put(key, node);     /* Add to the hashmap and the actual list that represents the cache */
                addToFront(node);
                ++totalItemInCache;

                if(totalItemInCache > maxCapacity) {    /* If over capacity remove the LRU item */
                    removeLRUEntry();
                }
            }
            else {  /* If item is found in the cache, just update it and Move to the front of the cache */
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(ListNode node) {
            removeFromList(node);
            addToFront(node);
        }

        private void removeFromList(ListNode node) {
            ListNode prevOfNodeToBeRemoved = node.prev;
            ListNode nextOfNodeToBeRemoved = node.next;

            prevOfNodeToBeRemoved.next = nextOfNodeToBeRemoved;
            nextOfNodeToBeRemoved.prev = prevOfNodeToBeRemoved;
        }

        private void addToFront(ListNode node) {
            node.prev = head;   /* Wire up the new node being to be inserted */
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeLRUEntry() {
            ListNode tailItem = popTail();
            map.remove(tailItem.key);
            --totalItemInCache;
        }

        private ListNode popTail() {
            ListNode tailItem = tail.prev;
            removeFromList(tailItem);
            return tailItem;
        }

        // doubly linked list
        private static class ListNode {
            private int key;
            private int value;

            private ListNode prev;
            private ListNode next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(br.readLine());
            int queries = Integer.parseInt(br.readLine());
            LRUCache cache = new LRUCache(capacity);
            String[] input = br.readLine().trim().split("\\s+");
            int len = input.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = input[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(input[itr++]);
                    int value = Integer.parseInt(input[itr++]);
                    cache.put(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(input[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
