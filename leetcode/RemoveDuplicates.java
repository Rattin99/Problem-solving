public class RemoveDuplicates {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null)
            return head;
        else
            helper(head);

        return head;

    }

    static public ListNode helper(ListNode x) {
        if (x.next.next == null && x.val == x.next.val) {
            x.next = null;
        }
        if (x.next.val == x.val && x.next.next.val == x.next.val && x.next.next.next != null) {
            x.next = x.next.next.next;
        }
        if (x.next.val == x.val && x.next.next.val == x.next.val && x.next.next.next == null) {
            x.next = null;
        }
        if (x.next == null)
            return x;

        else if (x.val == x.next.val) {
            x.next = x.next.next;
        }

        return deleteDuplicates(x.next);
    }

    static public void addNode(ListNode head, int val) {
        ListNode currentNode = head;
        while (currentNode.next != null) {

            currentNode = currentNode.next;
        }
        currentNode.next = new ListNode(val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        addNode(head, 1);
        addNode(head, 1);
        addNode(head, 2);
        addNode(head, 3);
        addNode(head, 3);

        deleteDuplicates(head);

        ListNode currentNode = head;

        while (currentNode != null) {

            System.out.println(currentNode.val);

            currentNode = currentNode.next;
        }
    }

}
