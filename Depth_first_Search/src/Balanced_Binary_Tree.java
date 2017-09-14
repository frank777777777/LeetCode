/**
 * Created by Frank on 7/22/2017.
 */
public class Balanced_Binary_Tree {
    /* Top down method. First check the depth difference between 2 children. It costs O(n), since we have to visit every children once.
    * And then we need to check each of the children to see the children themselves are balanced, this cost O(n) as well.
    * So the overall running complexity is O(n^2)*/
//    public boolean isBalanced(TreeNode root){
//        if(root==null)
//            return true;
//        return Math.abs(max_depth_helper(root.left)-max_depth_helper(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int max_depth_helper(TreeNode root){
//        if(root==null)
//            return 0;
//        return 1+Math.max(max_depth_helper(root.left),max_depth_helper(root.right));
//    }

    /* Faster method, when already detected 1 unbalance nodes, then directly return -1(unbalanced) instead of computing height difference */
    public boolean isBalanced(TreeNode root){
        return root==null ? true : height(root)!=-1;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        int l=height(root.left);
        if(l==-1) return -1;
        int r=height(root.right);
        if(r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return 1+Math.max(l,r);
    }
    public static void main(String[] args){
        Integer[] nums = {1,2,3,4};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Balanced_Binary_Tree().isBalanced(root));
    }


}
