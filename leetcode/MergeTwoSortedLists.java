
class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static class ListNode {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();

        if (l1 == null && l2 == null)
            return null;

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            node.val = l1.val;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node.val = l2.val;
            node.next = mergeTwoLists(l1, l2.next);
        }

        return node;
    }

}