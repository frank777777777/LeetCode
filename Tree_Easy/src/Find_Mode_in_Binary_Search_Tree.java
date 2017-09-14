import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
       1
        \
         2
        /
      2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Find_Mode_in_Binary_Search_Tree {
    /* working code. Use dfs to check every node top down, for each node, check its subtree, and count number of nodes
    * that have the same value */
//    public int[] findMode(TreeNode root) {
//        LinkedList<Integer> list = new LinkedList<>();
//        dfs(root,list,0);
//        int[] intarrs = new int[list.size()];
//        Iterator<Integer> itr = list.iterator();
//        int k=0;
//        while(itr.hasNext()){
//            intarrs[k]=itr.next();
//            k++;
//        }
//        return intarrs;
//    }
//    private int dfs(TreeNode node,LinkedList<Integer> list, int max){
//        if(node==null)
//            return max;
//        int count = 1+node_count(node.left,node)+node_count(node.right,node);
//        if(count==max){
//            list.add(node.val);
//        }else if(count>max){
//            list.clear();
//            list.add(node.val);
//            max=count;
//        }
//        max = Math.max(max,dfs(node.left,list,max));
//        max = Math.max(max,dfs(node.right,list,max));
//        return max;
//    }
//    private int node_count(TreeNode node, TreeNode parent){
//        if(node==null)
//            return 0;
//        int children_count = node_count(node.left,parent)+node_count(node.right,parent);
//        return node.val==parent.val ? children_count+1 : children_count;
//    }
    TreeNode pre=null;
    int max=0;
    int count=0;
    public int[] findMode(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        in_order_search(root,list);
        int[] intarrs = new int[list.size()];
        Iterator<Integer> itr = list.iterator();
        int k=0;
        while(itr.hasNext()){
            intarrs[k]=itr.next();
            k++;
        }
        return intarrs;
    }
    public void in_order_search(TreeNode node, LinkedList<Integer> list){
        if(node==null){
            return;
        }
        if(node.left!=null){
            in_order_search(node.left,list);
        }

        if(pre==null || node.val!=pre.val){
            count=1;
        }else {
            count++;
        }
        if(count==max){
            list.add(node.val);
        }else if(count>max){
            list.clear();
            list.add(node.val);
            max=count;
        }
        pre = node;
        if(node.right!=null) {
            in_order_search(node.right, list);
        }
        return;
    }
    public static void main(String[] args){
        Integer[] nums = {7,5,8,5,5,8,8,2,null,null,null,null,null,8};
        TreeNode root = new Build_Tree().build(nums);
        int [] res = new Find_Mode_in_Binary_Search_Tree().findMode(root);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
