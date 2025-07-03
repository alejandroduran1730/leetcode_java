package reverselinkedlist;

/**
 * Problem: #206 Reversed Linked List
 *
 * Description:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Note: To test both methods, just comment one, and test the other, and vice versa.
 */

public class ReverseLinkedList {

    /**
     * Solution 1:
     * Iterative solution:
     * This method is most common in interviews.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode reverseList (ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Solution 2:
     * Recursive solution:
     * Elegant, but less common.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
/*    public static ListNode reverseList(ListNode head) {
        // Base case: empty list or last node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest list
        ListNode newHead = reverseList(head.next);

        // Put current node at the end
        head.next.next = head;
        head.next = null;

        return newHead;
    }*/

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Build the list: 1 → 2 → 3 → 4 → null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);  // Output: 1 → 2 → 3 → 4 → null

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed list (Iterative solution):");
        printList(reversedHead);  // Output: 4 → 3 → 2 → 1 → null
    }
}