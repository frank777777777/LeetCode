import java.util.LinkedList;
import java.util.List;

/**Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 * */
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        String parenthsis = "";
        generateParenthesisHelper(n, n, parenthsis, res);

        return res;
    }
    /* DFS search */
    public void generateParenthesisHelper(int start, int close, String parenthesis, List<String> res){
        /* wrong case ,return */
        if(start > close) return;
        /* base case, add to list */
        if(start == 0 && close == 0){
            res.add(parenthesis);
            return;
        }
        /* for every level, add a start parenthesis and a close parenthesis */
        if(start > 0){
            generateParenthesisHelper(start - 1, close, parenthesis + "(", res);
        }
        if(close > 0){
            generateParenthesisHelper(start, close - 1, parenthesis + ")", res);
        }
    }

    public static void main(String[] args){
        Generate_Parentheses gp = new Generate_Parentheses();
        List<String> res = gp.generateParenthesis(3);
        for(String st : res){
            System.out.print(st+"\n");
        }
    }
}
