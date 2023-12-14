public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    void display() {
        ListNode tmp = this;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}