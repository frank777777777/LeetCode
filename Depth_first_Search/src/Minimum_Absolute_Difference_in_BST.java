import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

    1
     \
      3
    /
   2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.


 */
public class Minimum_Absolute_Difference_in_BST {
    /* Working code, but slow. O(nlogn) complexity. Using dfs and add all element to priority queue. pop the queue
    * until empty, and calculate the minimum difference */
//    public int getMinimumDifference(TreeNode root) {
//        if(root==null)
//            return 0;
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        /* put all elements in the priority queue */
//        dfs(root,heap);
//        int min=Integer.MAX_VALUE;
//        /* pre is the previous value, pop is the newly popped value */
//        int pre=heap.poll();
//        int pop;
//        while(!heap.isEmpty()){
//            pop=heap.poll();
//            if(pop-pre<min)
//                min=pop-pre;
//            pre=pop;
//        }
//        return min;
//    }
//    public void dfs(TreeNode node, PriorityQueue<Integer> heap){
//        heap.add(node.val);
//        if(node.left!=null)
//            dfs(node.left,heap);
//        if(node.right!=null)
//            dfs(node.right,heap);
//    }

    /* Because this is BFS, in-order search we can get the values in sorted order */
    /* Using in-order search */
    public int getMinimumDifference(TreeNode root){
        int[] info= new int[2];
        /* initialization, the min is maximum value, and if info[0] is -1, meaning there is no previous value yet. */
        info[1]=Integer.MAX_VALUE;
        info[0]=-1;
        info = in_order_search(root,info);
        return info[1];
    }
    /* info array carries the information to pass and return. info[0] is the previous value, info[1] is the global
    * minimum difference */
    public int[] in_order_search(TreeNode node, int[] info){
        if(node==null)
            return info;
        if(node.left!=null){
            info = in_order_search(node.left,info);
        }
        if(info[0]!=-1){
            info[1]=Math.min(info[1],Math.abs(info[0]-node.val));
        }
        info[0]=node.val;
        if(node.right!=null){
            info = in_order_search(node.right,info);
        }
        return info;
    }


    public static void main(String[] args){
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer[] nums = {0,null,2236,1277,2776,519};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Minimum_Absolute_Difference_in_BST().getMinimumDifference(root));

    }



}
