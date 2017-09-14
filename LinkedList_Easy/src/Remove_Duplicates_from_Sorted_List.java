/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
                continue;
            }
            head=head.next;
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,2,3,3,3,3};
        ListNode head = new Build_list().build_list(nums);
        head = new Remove_Duplicates_from_Sorted_List().deleteDuplicates(head);
        while(head!=null){
            System.out.print(head.val+" ");
            if(head.next!=null)
                head=head.next;
            else
                head=null;
        }

    }
}
