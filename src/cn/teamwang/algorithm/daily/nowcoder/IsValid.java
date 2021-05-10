package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Stack;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("["));
        System.out.println(isValid("[]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        // 对称 栈 先进后出
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
