/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

                   3
                  / \
                4   5
              / \
            1   2
 Given tree t:
                 4
                / \
              1   2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

                 3
               / \
             4   5
           / \
          1   2
             /
            0
 Given tree t:
                    4
                   / \
                  1   2
 Return false.
 */
public class Subtree_of_Another_Tree {
    /* returns true if s contains a subtree, that has the same structure and node values */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /* if one of them is null, return false. It they are both null, return true */
        if(s==null || t==null){
            return s==t;
        }
        /* if the root value matches, start compare the rest of tree, If failed,try its left child or its right child */
        if(s.val==t.val && matches(s,t)){
            return true;
        }else{
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }
    }
    /* return true if s and t has the same structure and node values*/
    private boolean matches(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val)
            return false;
        return matches(s.left,t.left) && matches(s.right,t.right);
    }
    public static void main(String[] args){
        Integer[] nums1= {-1,-4,8,-6,-2,3,9,null,-5,null,null,0,7};
        Integer[] nums2 = {3,0,5848};
        TreeNode s = new Build_Tree().build(nums1);
        TreeNode t = new Build_Tree().build(nums2);
        System.out.print(new Subtree_of_Another_Tree().isSubtree(s,t));
    }
}
