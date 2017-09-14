/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

*/



public class Construct_String_from_Binary_Tree {


    /*
    * Input the root of the tree, and return the String*/
    public static String tree2str(TreeNode t) {
        String str = "";
        str = recursion(str, t);
        return str;
    }

    public static String recursion(String mystr, TreeNode t){
        /* print itself first, then go down a level*/
        mystr = mystr.concat(Integer.toString(t.val));

        /* when it is a leaf, append and return*/
        if(t.left == null && t.right == null){
            return mystr;
        }

        /* it both children are not empty, go down a level, to the left, and then right */
        if(t.left != null && t.right != null){
            mystr = mystr.concat("(");
            mystr = recursion(mystr, t.left);
            mystr = mystr.concat(")");

            mystr = mystr.concat("(");
            mystr = recursion(mystr, t.right);
            mystr = mystr.concat(")");
        }

        /* go down a level to the right, when there is no left child */
        if(t.left == null && t.right != null){
            mystr = mystr.concat("()");
            mystr = mystr.concat("(");
            mystr = recursion(mystr, t.right);
            mystr = mystr.concat(")");
        }

        /* skip it when right chile is empty */
        if(t.left != null && t.right == null){
            mystr = mystr.concat("(");
            mystr = recursion(mystr, t.left);
            mystr = mystr.concat(")");

            return mystr;
        }
        return mystr;
    }

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(1);
        TreeNode test2 = new TreeNode(2);
        TreeNode test3 = new TreeNode(3);
        TreeNode test4 = new TreeNode(4);

        test1.left = test2;
        test1.right = test3;
        test2.right = test4;

        String print;
        print = tree2str(test1);
        System.out.print(print);

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x; }
}



























