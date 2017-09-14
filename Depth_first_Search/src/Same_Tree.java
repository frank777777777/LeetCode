/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* if they are both null, return true. If one of them is null, return false */
        if(p==q)
            return true;
        else if(q==null ^ p==null)
            return false;
        /* Compare their value, and then recursively compare their children */
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(4);
        root1.left = node11;
        root1.right = node12;
        node12.right = node13;

        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(6);
        TreeNode node23 = new TreeNode(4);
        root2.left = node21;
        root2.right = node22;
        node22.right = node23;

        boolean result = new Same_Tree().isSameTree(root1,root2);
        System.out.print(result);

    }


}
