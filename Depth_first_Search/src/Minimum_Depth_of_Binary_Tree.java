/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        return root==null? 0 : min_depth_helper(root);
    }
    public int min_depth_helper(TreeNode root){
        /* only count if it is a leaf, therefore no children */
        if(root.left==null && root.right==null)
            return 1;
        /* Recursively compute the left and right depth to a leave, and leave only, otherwise the initial value is huge
        * and being ignored */
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left!=null)
            left = 1+min_depth_helper(root.left);
        if(root.right!=null)
            right = 1+min_depth_helper(root.right);
        return Math.min(left,right);
    }
    public static void main(String[] args){
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(2);
        TreeNode node4= new TreeNode(3);
        TreeNode node5= new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        node3.right=node5;
        System.out.print(new Minimum_Depth_of_Binary_Tree().minDepth(node1));
    }
}
