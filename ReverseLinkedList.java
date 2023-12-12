import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution206 solution = new Solution206();
        ListNode head  = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <=5 ; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;

        }


        ListNode node = new ListNode();
        node.next=new ListNode(1);
        node= node.next;
        node.next.next=new ListNode(2);
        node= node.next;
        node.next=new ListNode(12);
        head= head.next;
        node.next=new ListNode(12);
        head= head.next;
        node.next=new ListNode(13);
        head= head.next;
        System.out.println(node.next);

        Stack<ListNode> stack = new Stack<>();
        stack.push(head);


//        Solution203 solution203 = new Solution203();
//        solution203.removeElements(head,3);

//        System.out.println(solution.reverseList(head));
    }
}

class Solution206{
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;

        ListNode current = head;
        while (current != null){
            temp = current.next;
            current.next= prev;
            prev =current;
            current = temp;
        }
        return prev;
    }
}

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-100,head);
        ListNode prev  = dummy;
        ListNode current = head;
        while (current != null){
            if(current.val == val){
                prev.next = current.next;
            }else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public  ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

//    static ListNode removeDuplicates(ListNode head){
//        //Write your code here
//    }
}

//define a singly-linked list
 class ListNode {
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

