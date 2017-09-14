import java.util.LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        /* remove all the preceding vals */
        while(head!=null && head.val==val){
            head=head.next;
        }
        ListNode backup_head=head;
        /* check for the next value, if equals to val, remove the next one, otherwise move to the next*/
        while(head!=null && head.next!=null){
            if(head.next.val==val)
                head.next=head.next.next;
            else
                head=head.next;
        }
        return backup_head;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,1};
        ListNode head = new Build_list().build_list(nums);
        head = new Remove_Linked_List_Elements().removeElements(head,2);
        while(head!=null){
            System.out.print(head.val+" ");
            if(head.next!=null)
                head=head.next;
            else
                head=null;
        }
    }
}
