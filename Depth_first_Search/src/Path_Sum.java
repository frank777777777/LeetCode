/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
           5
          / \
        4   8
       /   / \
      11  13  4
     /  \      \
   7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return hasPathSum_helper(root,0,sum);
    }
    public boolean hasPathSum_helper(TreeNode node, int current, int sum){
        boolean result=false;
        int value = current+node.val;
        /* Return true only if the sum is satisfied, and the node is a leaf */
        if(value==sum && node.left==null && node.right==null)
            return true;
        /* Check left branch, if not satisfied, then check right branch */
        if(node.left!=null){
            result = hasPathSum_helper(node.left,value,sum);
        }
        if(!result){
            if(node.right!=null){
                result = hasPathSum_helper(node.right,value,sum);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Integer[] nums = {1};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Path_Sum().hasPathSum(root,1));
    }
}
