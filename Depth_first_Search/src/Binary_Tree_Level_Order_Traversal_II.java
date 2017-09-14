import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root==null)
            return result;
        /* Offer root to the queue, the queue store each row of values */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /* Stop when there is no next row */
        while(!queue.isEmpty()){
            /* Number of elements in this row */
            int size = queue.size();
            List<Integer> row = new LinkedList<>();
            /* Iterate throw the row, if there is child, put it in the queue for the next time scanning */
            while (size-- >0){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
        }
            result.add(0,row);
        }
        return result;
    }

    public static void main(String[] args){
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = new Build_Tree().build(nums);
        List<List<Integer>> list = new Binary_Tree_Level_Order_Traversal_II().levelOrderBottom(root);
        for(List<Integer> row: list){
            for(Integer value: row){
                System.out.print(value+" ");
            }
            System.out.print("\n");
        }

    }
}
