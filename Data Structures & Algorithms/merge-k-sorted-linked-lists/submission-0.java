/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class HeapNode {
    int value;
    ListNode listNode;

    HeapNode(int value, ListNode listNode) {
        this.value = value;
        this.listNode = listNode;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int n = lists.length;
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        // Using n pointers
        ListNode[] pointers = new ListNode[n];
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                minHeap.add(new HeapNode(lists[i].val, lists[i]));
            }
        }
        while(!minHeap.isEmpty()) {
            HeapNode heapNode = minHeap.poll();
            temp.next = heapNode.listNode;
            temp = temp.next;
            if (heapNode.listNode.next != null) {
                minHeap.add(new HeapNode(heapNode.listNode.next.val, heapNode.listNode.next));
            }
        }
        temp.next = null;
        return head.next;
    }
}
