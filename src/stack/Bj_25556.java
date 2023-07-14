package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Bj_25556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] arr = new int[A.length];
        boolean isOk = true;


        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        ArrayList<Stack<Integer>> stack_list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            stack_list.add(new Stack<>());
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < stack_list.size(); j++) {
                if (!stack_list.get(j).isEmpty()) {
                    if (stack_list.get(j).peek() > A[i]) {
                        continue;
                    }
                    stack_list.get(j).add(A[i]);
                } else {
                    stack_list.get(j).push(A[i]);
                }
                break;
            }
        }

        int idx = 0;

        for (int i = 0; i < stack_list.size(); i++) {
            int size = stack_list.get(i).size();

            for (int j = 0; j < size; j++) {
                if (!stack_list.get(i).isEmpty()) {
                    arr[idx++] = stack_list.get(i).pop();
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                isOk = false;
                break;
            }
        }

        System.out.println(isOk ? "YES" : "NO");

    }
}
