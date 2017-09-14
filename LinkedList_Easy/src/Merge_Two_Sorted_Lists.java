/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode node;
        if(l1.val<l2.val){
            node=l1;
            node.next=mergeTwoLists(l1.next,l2);
        }else{
            node=l2;
            node.next=mergeTwoLists(l1,l2.next);
        }
        return node;
    }
    public static void main(String[] args){
        int[] num1={1,1,4,5,7,8,9};
        int[] num2={1,2,3,5,6,10};
        ListNode head1 = new Build_list().build_list(num1);
        ListNode head2 = new Build_list().build_list(num2);
        ListNode result = new Merge_Two_Sorted_Lists().mergeTwoLists(head1,head2);
        while(result!=null){
            System.out.print(result.val+" ");
            if(result.next!=null)
                result=result.next;
            else
                result=null;
        }
    }
}
