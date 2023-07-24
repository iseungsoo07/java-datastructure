package 선형자료구조.stack;

// Practice2
// 배열을 이용한 기본 스택 직접 구현

import java.util.Arrays;

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        top += 1;
        arr[top] = data;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = arr[top];
        top -= 1;
        return data;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return arr[top];
    }

    public void printStack() {
        System.out.println(Arrays.toString(arr));
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyStack2 myStack = new MyStack2(5);
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.peek()); // 5
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.pop());  // 5
        System.out.println(myStack.pop());  // 4
        myStack.printStack();               // 1, 2, 3

        System.out.println(myStack.pop());  // 3
        System.out.println(myStack.pop());  // 2
        System.out.println(myStack.pop());  // 1
        myStack.printStack();
    }
}
