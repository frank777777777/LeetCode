import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '(')
                stack.push(')');
            else if(temp == '{')
                stack.push('}');
            else if(temp == '[')
                stack.push(']');
            else if(temp == ')' || temp == '}' || temp == ']'){
                if(stack.empty() || stack.pop() != temp)
                    return false;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args){
        String test = "(({)}";
        System.out.print(new Valid_Parentheses().isValid(test));
    }

}
