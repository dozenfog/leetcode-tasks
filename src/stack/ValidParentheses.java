package stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '{', '[' -> stack.push(s.charAt(i));
                case ')' -> {
                    if (stack.empty() || stack.peek() != '(') return false;
                    else stack.pop();
                }
                case '}' -> {
                    if (stack.empty() || stack.peek() != '{') return false;
                    else stack.pop();
                }
                case ']' -> {
                    if (stack.empty() || stack.peek() != '[') return false;
                    else stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
