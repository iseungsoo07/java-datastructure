package 비선형자료구조.연습문제1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {
    public static int solution(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();

        queue.offer("0000");
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curNum = queue.poll();

                if (!visited.add(curNum)) {
                    continue;
                }

                if (curNum.equals(target)) {
                    return cnt;
                }

                for (String nextNum : getNextNums(curNum.toCharArray())) {
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public static LinkedList<String> getNextNums(char[] cArr) {
        LinkedList<String> nums = new LinkedList<>();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            cArr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c;
        }

        return nums;
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
