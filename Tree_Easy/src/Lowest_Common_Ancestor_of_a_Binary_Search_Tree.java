/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    /* Just note it is BST, the LCA is always in the middle */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* if q and p are in different sides, of one of them equals to root, we found the LCA */
        /* if they are all in one side of the tree, go down that side and keep searching */
        if(p.val<root.val){
            if(q.val<root.val){
                return lowestCommonAncestor(root.left,p,q);
            }else {
                return root;
            }
        }
        if(p.val>root.val){
            if(q.val>root.val){
                return lowestCommonAncestor(root.right,p,q);
            }else {
                return root;
            }
        }
        return root;
    }
    public static void main(String[] args){
        Integer[] nums={6,2,8,0,4,7,9,null,null,3,5,null,null,null,null};
        TreeNode root = new Build_Tree().build(nums);
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        System.out.print(new Lowest_Common_Ancestor_of_a_Binary_Search_Tree().lowestCommonAncestor(root,p,q).val);
    }
}
