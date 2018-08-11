import java.util.*;
public class Solution {
    //Determine if a string of parentheses is properly nested.

    //time Complexity: O(N)
    //stack not needed
    public int solution(String S){
        if (S == null) return 0;
        if (S.isEmpty()) return 1;
        //only even strings can be balanced
        if (S.length() % 2 != 0)
            return 0;

        int openingBrackets =0;

        for (int i=0;i<S.length();i++){

            if ( S.charAt(i) == '(')
                openingBrackets++; //opening brackets -not closed- until pos i
            else if (S.charAt(i) == ')') {
                //check if there is an opening bracket to close
                // if not then string unbalanced
                if (openingBrackets == 0)
                    return 0;
                //if there is "close" one opening bracket
                openingBrackets--;
            }

        }
        if (openingBrackets!=0) return 0;
        return 1;
    }

    //solution with stack
    public int solution2(String S){
        if (S == null) return 0;
        if (S.isEmpty()) return 1;
        //only even strings can be balanced
        if (S.length() % 2 != 0)
            return 0;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)=='(')
                stack.push(S.charAt(i));

            else if (S.charAt(i)==')'){
                    //if stack is empty or there is not an opening bracket
                    //at the top of the stack
                    if (stack.isEmpty() || stack.peek() != '(')
                        return 0;
                    //remove head
                    stack.pop();

            }
        }
        if (!stack.isEmpty())
            return 0;

        return 1;


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "(()(())())";
        int nested = sol.solution(S);
        int nested2 = sol.solution2(S);
        System.out.println(nested);
    }
}
