import java.util.List;

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        /* walker move 1 node at a time ,runner move 2 nodes at a time. If there is a cycle, they will meet again.
        * If they reach the end, means there is no cycle. Since runner is faster, we just check the runner for reaching
        * the end. */
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner)
                return true;
        }
        return false;
    }

    /* Slower but still O(n), loop from the second node, see if it get back to the head */
//    public boolean hasCycle(ListNode head){
//        if(head==null || head.next==null)
//            return false;
//        ListNode next = head.next;
//        while(next.next!=null){
//            if(next.next==head)
//                return true;
//            next = next.next;
//        }
//        return false;
//    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        ListNode non_cycle = new Build_list().build_list(nums);
        ListNode cycle = new Build_list().build_list(nums);
        cycle.next.next.next.next.next.next.next.next = cycle;

        System.out.println("test for non_cycle: "+ new Linked_List_Cycle().hasCycle(non_cycle));
        System.out.print("test for cycle: "+ new Linked_List_Cycle().hasCycle(cycle));

    }
}
