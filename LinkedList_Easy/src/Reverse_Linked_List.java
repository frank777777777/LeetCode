/**
 * Reverse a singly linked list.
 */
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode temp;
        ListNode new_head=head;
        while(head.next!=null){
            temp=head.next;
            head.next=head.next.next;
            temp.next=new_head;
            new_head=temp;
        }
        return new_head;
    }

}
