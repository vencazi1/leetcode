public class AddTwoNumbers {

    public int[] getReminderAndCarryOver(int sum) {
        int quotient;
        int reminder;
        if (sum > 9) {
            quotient = sum / 10;
            reminder = sum % 10;
        } else {
            quotient = 0;
            reminder = sum;
        }
        return new int[] {reminder, quotient};
    }

    void computeRemainingList(ListNode listNode, ListNode l3, int carryOver) {
        while (listNode != null) {
            int sum;
            if (carryOver > 0) {
                sum = listNode.val + carryOver;
                int[] valueArray = getReminderAndCarryOver(sum);
                carryOver = valueArray[1];
                ListNode ansNode = new ListNode(valueArray[0]);
                l3.next = ansNode;
                l3 = ansNode;
                listNode = listNode.next;
            } else {
                // just pint l3 to l1;
                l3.next = listNode;
                break;
            }
        }
        if (carryOver > 0) {
            l3.next = new ListNode(carryOver);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3Head = null;
        int sum;
        int[] valueArray = new int[2];
        int carryOver = valueArray[1];
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carryOver;
            valueArray = getReminderAndCarryOver(sum);
            ListNode ansNode = new ListNode(valueArray[0]);
            if (l3 == null) {
                l3 = ansNode;
                l3Head = l3;
            } else {
                l3.next = ansNode;
                l3 = ansNode;
            }
            l1 = l1.next;
            l2 = l2.next;
            carryOver = valueArray[1];
        }
        if (l1 != null) {
            computeRemainingList(l1, l3, carryOver);
        } else if (l2 != null) {
            computeRemainingList(l2, l3, carryOver);
        } else if (carryOver > 0) {
            l3.next = new ListNode(carryOver);
        }
        return l3Head;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        // 9,9,9,9,9,9,9
        /*ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);*/
        ListNode l3 = addTwoNumbers.addTwoNumbers(new ListNode(9, new ListNode(9)),
                new ListNode(9, new ListNode(9)));
        l3.display();
    }
}