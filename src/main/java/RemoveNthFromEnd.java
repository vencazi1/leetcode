import java.util.Stack;

/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tptr = head;
        while (tptr != null) {
            stack.push(tptr);
            tptr = tptr.next;
        }
        int ind = 1;
        head = null;
        while(!stack.isEmpty()) {
            ListNode listNode = stack.pop();
            if (ind != n) {
                if (head == null) {
                    head = listNode;
                    head.next = null;
                } else {
                    listNode.next = head;
                    head = listNode;
                }
            }
            ind = ind + 1;
        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        ListNode head = removeNthFromEnd.removeNthFromEnd(ln, 2);
        display(head);
        ln = new ListNode(1);
        head = removeNthFromEnd.removeNthFromEnd(ln, 1);
        display(head);
        ln = new ListNode(1, new ListNode(2));
        head = removeNthFromEnd.removeNthFromEnd(ln, 1);
        display(head);
    }
}
