package stack;

// Exercise3

// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 전위 + 2 2
// 중위 2 + 2
// 후위 2 2 +
// (1+2)x3 -> 모든 부분에 괄호를 처리 -> ((1+2)x3) 연산자를 가장 가까운 괄호 밖으로 빼내는 것이 후위 표기법
// -> 12+3x
// 1+2x3 -> (1+(2x3)) -> 123x+

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class Exercise3 {
    public static double calculate(String string) {
        Stack<Double> stack = new Stack();

        for (String str : string.split(" ")) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(str));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));    // 4
        System.out.println(calculate("2 2 -"));    // 0
        System.out.println(calculate("2 2 *"));    // 4
        System.out.println(calculate("2 2 /"));    // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14

    }
}
