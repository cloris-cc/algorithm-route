package cn.teamwang.algorithm.modest;

import java.util.Stack;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsValid {
    public static void main(String[] args) {
//        System.out.println(test("()[]{}"));
//        System.out.println(test("{[]}"));
//        System.out.println(test("]"));
        System.out.println(test("()"));
//        test("([)]");
    }

    public static boolean test(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 正向括号
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // 反向括号
                if (!stack.empty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
