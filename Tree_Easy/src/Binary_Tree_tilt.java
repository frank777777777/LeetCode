/**
 * Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
 1
 /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1
 */
public class Binary_Tree_tilt {
    int tree_tilt=0;
    public int findTilt(TreeNode root) {
        calculate_tree_tile(root);
        return tree_tilt;
    }
    private int calculate_tree_tile(TreeNode root){
        if(root==null)
            return 0;
        int left_sum = calculate_tree_tile(root.left);
        int right_sum = calculate_tree_tile(root.right);
        tree_tilt+=Math.abs(left_sum-right_sum);
        return left_sum+right_sum+root.val;
    }
    public static void main(String[] args){
        Integer[] nums= {1,2,3};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Binary_Tree_tilt().findTilt(root));
    }
}
