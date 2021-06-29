import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{{{{{}}}}}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();
        char[] parantheses = s.toCharArray();

        for (int i = 0; i < parantheses.length; i++) {
            if (pStack.isEmpty() && (parantheses[i] == ')' || parantheses[i] == '}' || parantheses[i] == ']')) {
                return false;
            } else {
                if (parantheses[i] == ')' && pStack.peek() == '(') {
                    pStack.pop();
                } else if (parantheses[i] == '}' && pStack.peek() == '{') {
                    pStack.pop();
                } else if (parantheses[i] == ']' && pStack.peek() == '[') {
                    pStack.pop();
                } else {
                    pStack.push(parantheses[i]);
                }

            }
        }

        return pStack.isEmpty();
    }
}
