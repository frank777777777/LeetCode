import java.util.List;

/**
 * Created by Frank on 7/26/2017.
 */
public class Build_list {
    public ListNode build_list(int[] nums){
        if(nums.length==0)
            return null;
        ListNode node = new ListNode(nums[0]);
        ListNode head = node;
        for(int i=1;i<nums.length;i++){
            ListNode new_node = new ListNode(nums[i]);
            node.next = new_node;
            node = new_node;
        }
        return head;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListNode node = new Build_list().build_list(nums);
        int i=1;
    }
}
