import java.util.Stack;
public class Solution {


    public int solution(String S){
//Determine if a string  is properly nested.
        if (S == null) return 0;
        if (S.isEmpty()) return 1;
        //only even strings can be balanced
        if (S.length() % 2 != 0)
            return 0;

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<S.length();i++){

            if (S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '[')
                stack.push(S.charAt(i));

            else  if (S.charAt(i)==')'){
                if (stack.isEmpty() || stack.peek() != '(')
                    return 0;
                stack.pop();
            }
            else  if (S.charAt(i)=='}'){
                if (stack.isEmpty() || stack.peek() != '{')
                    return 0;
                stack.pop();
            }
            else  if (S.charAt(i)==']'){
                if (stack.isEmpty() || stack.peek() != '[')
                    return 0;
                stack.pop();
            }

        }
            if (!stack.isEmpty())
                return 0;

            return 1;
    }
    public static void main(String[] args) {
        Solution sol =new Solution();
        String S = "{[()()]}";
        int isNested = sol.solution(S);
        System.out.println(isNested);

    }
}
