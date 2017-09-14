import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

         1
       /   \
      2     3
       \
        5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        /* initialization */
        List<String> list = new LinkedList<>();
        if(root==null)
            return list;
        String path = "";
        binaryTreePaths_helper(root,list,path);
        return list;

    }
    public void binaryTreePaths_helper(TreeNode node, List<String> list, String path){
        /* When node is a leaf, add it to the list */
        if(node.left==null && node.right==null){
            path = path+node.val;
            list.add(path);
        }
        /* When node is not a leaf, concatenate the arrow and go left and right recursively */
        path = path+node.val+"->";
        if(node.left!=null)
            binaryTreePaths_helper(node.left,list,path);
        if(node.right!=null)
            binaryTreePaths_helper(node.right,list,path);
    }
    public static void main(String[] args){
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = new Build_Tree().build(nums);
        List<String> list = new Binary_Tree_Paths().binaryTreePaths(root);
        for(String str: list)
            System.out.print(str+" , ");
    }
}
