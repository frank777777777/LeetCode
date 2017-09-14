import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
//    public TreeNode sortedArrayToBST(int[] nums) {
//
//        int len = nums.length;
//        if ( len == 0 ) { return null; }
//
//        // 0 as a placeholder
//        TreeNode head = new TreeNode(0);
//
//        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
//        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
//        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};
//
//        while ( !nodeStack.isEmpty() ) {
//            TreeNode currNode = nodeStack.pop();
//            int left  = leftIndexStack.pop();
//            int right = rightIndexStack.pop();
//            int mid   = left + (right-left+1)/2; // avoid overflow
//            currNode.val = nums[mid];
//            if ( left <= mid-1 ) {
//                currNode.left = new TreeNode(0);
//                nodeStack.push(currNode.left);
//                leftIndexStack.push(left);
//                rightIndexStack.push(mid-1);
//            }
//            if ( mid+1 <= right ) {
//                currNode.right = new TreeNode(0);
//                nodeStack.push(currNode.right);
//                leftIndexStack.push(mid+1);
//                rightIndexStack.push(right);
//            }
//        }
//        return head;
//    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;

        Stack<Integer> stack_start = new Stack<>();
        Stack<Integer> stack_end = new Stack<>();
        Stack<TreeNode> stack_nodes = new Stack<>();
        stack_start.push(0);
        stack_end.push(nums.length-1);
        /* Just initialization, make it not empty */
        TreeNode root = new TreeNode(0);
        stack_nodes.push(root);

        while(!stack_nodes.isEmpty()){
            int start = stack_start.pop();
            int end = stack_end.pop();
            TreeNode node = stack_nodes.pop();
            /* Avoid overflow */
            int medium = start+(end-start+1)/2;
            node.val = nums[medium];
            if(start<medium) {
                /* Just insert whatever value, because if this branch executes, means there must be a child, so we will
                * assign a value in the next iteration */
                node.left = new TreeNode(0);
                stack_start.push(start);
                stack_end.push(medium-1);
                stack_nodes.push(node.left);
            }
            if(medium<end){
                node.right = new TreeNode(0);
                stack_start.push(medium+1);
                stack_end.push(end);
                stack_nodes.push(node.right);
            }
        }
        return root;
    }


    /* Recursive method */
//    public TreeNode sortedArrayToBST(int[] nums){
//        /* call for the recursive call */
//        TreeNode root = sortedArrayToBST_helper(nums,0,nums.length-1);
//        return root;
//    }
//    public TreeNode sortedArrayToBST_helper(int[] nums, int begin, int end){
//        /* if begin is greater than end, means there is no value in between */
//        if(begin>end)
//            return null;
//        int medium = (begin+end)/2;
//        /* put the medium value as root */
//        TreeNode root = new TreeNode(nums[medium]);
//        /* recursively put left and right children */
//        root.left = sortedArrayToBST_helper(nums,begin,medium-1);
//        root.right = sortedArrayToBST_helper(nums,medium+1,end);
//        return root;
//    }
    public static void main(String[] args){
        int[] nums = {1,3,5,8};
        TreeNode root = new Convert_Sorted_Array_to_Binary_Search_Tree().sortedArrayToBST(nums);
        int i=0;
    }


}
