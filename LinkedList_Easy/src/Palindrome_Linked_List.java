import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */

public class Palindrome_Linked_List {
    /* O(n) time, O(n) space method */
//    public boolean isPalindrome(ListNode head) {
//        ListNode temp_head = head;
//        ListNode new_head=null;
//        /* O(n) to build a reversed list, with new_head node */
//        while(temp_head!=null){
//            ListNode temp = new ListNode(temp_head.val);
//            temp.next = new_head;
//            new_head = temp;
//            if(temp_head.next!=null)
//                temp_head=temp_head.next;
//            else
//                temp_head=null;
//        }
//        /* the new list is the same length as the old one. Compare each value with the old one */
//        while(head!=null){
//            if(head.val!=new_head.val)
//                return false;
//            if(head.next!=null){
//                head=head.next;
//                new_head=new_head.next;
//            }
//            else
//                head=null;
//        }
//        return true;
//    }

    /* O(n) time and O(1) space. Reverse the second half in place and compare with the first half. No extra space needed,
    * however altered the input. But we can reverse it back it needed */
    public boolean isPalindrome(ListNode head){
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        /* slow reaches to the middle, and fast reaches to the last node or null , if fast is not null, then
        * the second half has one more element, so we move slow one more */
        if(fast!=null)
            slow=slow.next;
        /* reverse the second half, and compare the first half to the second halo, if not matches, return false,
        * otherwise true */
        ListNode new_head = reverse(slow);
        while(new_head!=null){
            if(head.val!=new_head.val){
                return false;
            }
            if(new_head.next!=null){
                new_head=new_head.next;
                head=head.next;
            }
            else
                new_head=null;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode next = head.next;
        ListNode new_head;
        new_head = reverse(next);
        head.next=null;
        next.next=head;
        return new_head;
    }
    public static void main(String[] args){
        int[] nums = {1,1,2,1};
        ListNode head = new Build_list().build_list(nums);
        System.out.print(new Palindrome_Linked_List().isPalindrome(head));
    }
}
