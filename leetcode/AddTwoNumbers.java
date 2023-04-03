import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        long number1 = ArrayToInt(l1);
        long number2 = ArrayToInt(l2);


        long result = number1 + number2;

        return intToListNode(result);
    }

    public long ArrayToInt(ListNode l) {

        long sum = 0;
        ListNode current = l;
        int i = 0;

        while(current != null){
           
            sum += (long) current.val * (Math.pow(10, i));
            i++;
            current = current.next;
        }

        return sum;
    }

    public ListNode intToListNode(long n){

        long remainder = n;


        int e1 = (int) (remainder % 10);
        ListNode r = new ListNode(e1);
        ListNode current = r;
        remainder = remainder / 10;

        while(remainder != 0){

            int e =(int) (remainder % 10);
            remainder = remainder/10;

            current.next = new ListNode(e);
            current = current.next;
            
        }



        return r;
    }
}


class main{
    public static void printer(ListNode l) {
        ListNode current = l;

        while(current != null) {
            
            System.out.println(current.val);

            current = current.next;
        }
    } 


    public static void main(String[] args) {

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7);
                l2.next = new ListNode(3);
                
        Solution2 s = new Solution2();

        ListNode result =  s.addTwoNumbers(l1, l2);

        printer(result);
        
        
    }

   
}


class Solution2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        int carry = 0;
        ListNode l1Current = l1.next;
        ListNode l2Current = l2.next;
        ListNode resultCurrent;

        int value = l1.val + l2.val;

        if(value >= 10){
            carry = value/10;
            value = value % 10;
        }
        ListNode result = new ListNode(value);
         
        resultCurrent = result;

        while(l1Current != null && l2Current != null){
            
            int v = l1Current.val + l2Current.val;

            v = v + carry;
            carry = 0;

            if(v >= 10){
                carry = v/10;
                v = v % 10;
            }

            resultCurrent.next = new ListNode(v);
            resultCurrent = resultCurrent.next;

            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }

        while(l1Current != null){
            int v = l1Current.val + carry;
            carry = 0;

            if(v >= 10) {
                carry = v/10;
                v = v%10;
            }

            resultCurrent.next = new ListNode(v);
            resultCurrent = resultCurrent.next;

            l1Current = l1Current.next;
        }

        while(l2Current != null){

            int v = l2Current.val + carry;
            carry = 0;

            if(v >= 10) {
                carry = v/10;
                v = v%10;
            }

            resultCurrent.next = new ListNode(v);
            resultCurrent = resultCurrent.next;

            l2Current = l2Current.next;
        }

        while(carry != 0){

            resultCurrent.next = new ListNode(carry);
            resultCurrent = resultCurrent.next;
            
            carry = 0;
        }

        return result;
    }
}