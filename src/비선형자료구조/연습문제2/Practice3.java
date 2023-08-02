package 비선형자료구조.연습문제2;

import java.util.PriorityQueue;

public class Practice3 {
    public static boolean solution(int[] target) {
        if (target == null || target.length == 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        int sum = 0;
        for (int num : target) {
            sum += num;
            pq.add(num);
        }

        while (pq.peek() != 1) {
            int num = pq.poll();
            sum -= num;

            if (num <= sum || sum < 1) {
                return false;
            }

            num -= sum;
            sum += num;
            pq.add(num > 0 ? num : sum);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
