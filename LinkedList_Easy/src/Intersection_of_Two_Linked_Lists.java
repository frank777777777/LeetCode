/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                        ↘
                            c1 → c2 → c3
                        ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.
 */
public class Intersection_of_Two_Linked_Lists {
    /* Reverse the two list, looking for the intersection, when found, reverse them back, and return the intersection
    * It actually changes the structure twice, so not meeting the requirement */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode reverse_headA = reverse(headA);
//        ListNode reverse_headB = reverse(headB);
//        ListNode reverse_headA_bak = reverse_headA;
//        ListNode reverse_headB_bak = reverse_headB;
//        if(reverse_headA==null || reverse_headB==null || reverse_headA.val!=reverse_headB.val){
//            reverse(reverse_headA_bak);
//            reverse(reverse_headB_bak);
//            return null;
//        }
//
//        while(reverse_headA.next!=null && reverse_headB.next!=null){
//            if(reverse_headA.next.val==reverse_headB.next.val){
//                reverse_headA=reverse_headA.next;
//                reverse_headB=reverse_headB.next;
//            }
//            else {
//                reverse(reverse_headA_bak);
//                reverse(reverse_headB_bak);
//                return reverse_headA;
//            }
//        }
//        reverse(reverse_headA_bak);
//        reverse(reverse_headB_bak);
//        return reverse_headA;
//    }
//    public ListNode reverse(ListNode head){
//        ListNode new_head=null;
//        ListNode next;
//        while(head!=null){
//            next = head.next;
//            head.next=new_head;
//            new_head=head;
//            head=next;
//        }
//        return new_head;
//    }
    /* method 1. get the length of headA, and length of headB. Align the end of both. Starts to check for intersection */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        int lengthA=length(headA);
//        int lengthB=length(headB);
//        /* Align the two list */
//        if(lengthA>lengthB){
//            headA=headA.next;
//            lengthA--;
//        }
//        if(lengthA<lengthB){
//            headB=headB.next;
//            lengthB--;
//        }
//        /* check for boundary */
//        if(headA==null || headB==null)
//            return null;
//        while(headA.val!=headB.val){
//            if(headA.next!=null){
//                headA=headA.next;
//                headB=headB.next;
//            }else
//                break;
//        }
//        return headA;
//    }
//    public int length(ListNode head){
//        int count=0;
//        while(head!=null){
//            head=head.next;
//            count++;
//        }
//        return count;
//    }

    /*Method 2. No need to calculate the length of them. Because lengthA+LengthB = LengthB+LengthA. For headA, if it
    * finishes looping listA, it starts loop listB. For headB, if it finishes looping listB, it starts loop listA.
     * They will converge at the second iteration if they have different length. */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        /* Boundary check */
        if(headA==null || headB==null)
            return null;
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a = a.next==null ? headB : a.next;  /* first iteration will go through its own list, after reaching
                                                the end, it will go through the other list */
            b = b.next==null ? headA : b.next;
        }
        return a;
    }
    public static void main(String[] args){
        int[] nums1={1,2,4};
        int[] nums2={3,5};
        int[] nums3={6,7,8,9};
        ListNode head_1 = new Build_list().build_list(nums1);
        ListNode head_2 = new Build_list().build_list(nums2);
        ListNode head_3 = new Build_list().build_list(nums3);
        head_1.next.next.next=head_3;
        head_2.next.next=head_3;
//        head = new Intersection_of_Two_Linked_Lists().reverse(head);
////        while(head!=null){
////            System.out.print(head.val+" ");
////            if(head.next!=null)
////                head=head.next;
////            else
////                head=null;
////        }
        ListNode node = new Intersection_of_Two_Linked_Lists().getIntersectionNode(head_1,head_2);
        System.out.print(node.val);
    }
}
