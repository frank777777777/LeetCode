import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

       1
      / \
     2   2
    / \ / \
   3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
       1
      / \
     2   2
      \   \
       3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class Symmetric_Tree {
    /* Recursive method */
//    public boolean isSymmetric(TreeNode root) {
//        return root==null || isSymmetric_helper(root.left,root.right);
//
//    }
//    public boolean isSymmetric_helper(TreeNode root1, TreeNode root2){
//        /* return true */
//        if(root1==null && root2==null)
//            return true;
//        /* one of the root is null, return false */
//        if(root1==null ^ root2==null)
//            return false;
//        /* Compare the value, and symmetrically compare their children */
//        return root1.val==root2.val && isSymmetric_helper(root1.left, root2.right) && isSymmetric_helper(root1.right, root2.left);
//    }

    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        Stack<TreeNode> stack_1 = new Stack<>();
        Stack<TreeNode> stack_2 = new Stack<>();
        stack_1.push(root);
        stack_2.push(root);
        /* They have to be both empty, so iterate all of them */
        while(!stack_1.isEmpty() || !stack_2.isEmpty()){
            TreeNode root1 = stack_1.pop();
            TreeNode root2 = stack_2.pop();
            /* compare the value */
            if(root1.val!=root2.val)
                return false;
            /* Compare their children's structure symmetrically, if not matches, return false */
            if((root1.left!=null^root2.right!=null) || (root1.right!=null^root2.left!=null))
                return false;
            /* push the children of root1 and root2 symmetrically */
            if(root1.left!=null && root2.right!=null){
                stack_1.push(root1.left);
                stack_2.push(root2.right);
            }
            if(root1.right!=null && root2.left!=null){
                stack_1.push(root1.right);
                stack_2.push(root2.left);
            }
        }
        return true;
    }
    public static void main(String[] args){
        Integer[] nums = {1,2,2,null,3,null,3};
        TreeNode root =new Build_Tree().build(nums);
        System.out.print(new Symmetric_Tree().isSymmetric(root));

    }

}
