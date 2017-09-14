import java.util.Stack;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
        1
       / \
      2   3
    / \
   4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Diameter_of_Binary_Tree {
    /* iterative version, no global variable */
//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root==null)
//            return 0;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        TreeNode temp;
//        int max=0;
//        while(!stack.isEmpty()){
//            temp = stack.pop();
//            int left_max_depth = temp.left==null ? 0 : max_depth(temp.left);
//            int right_max_depth = temp.right==null ? 0 : max_depth(temp.right);
//            max = Math.max(max,left_max_depth+right_max_depth);
//
//            if(temp.left!=null && left_max_depth*2>=max)
//                stack.push(temp.left);
//            if(temp.right!=null && right_max_depth*2>=max)
//                stack.push(temp.right);
//            if(left_max_depth*2<max && right_max_depth*2<max)
//                break;
//        }
//        return max;
//    }
    /* For every node, the longest path pass it, will be the longest depth of its left plus its the lonest depth of its right */
//    int max=0;
//    public int diameterOfBinaryTree(TreeNode root){
//        if(root==null)
//            return 0;
//        int left_max_depth = root.left==null ? 0 : max_depth(root.left);
//        int right_max_depth = root.right==null ? 0 : max_depth(root.right);
//        max = Math.max(max,left_max_depth+right_max_depth);
//        if(root.left!=null && left_max_depth*2>=max)
//            diameterOfBinaryTree(root.left);
//        if(root.right!=null && right_max_depth*2>=max)
//            diameterOfBinaryTree(root.right);
//        return max;
//    }
//    public int max_depth(TreeNode node){
//        if(node==null)
//            return 0;
//        return 1+Math.max(max_depth(node.left),max_depth(node.right));
//    }

    /* more concise version*/
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
    public static void main(String[] args){
        Integer[] nums = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Diameter_of_Binary_Tree().diameterOfBinaryTree(root));
    }
}
