package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Bj_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        IntStream.range(1, N + 1).forEach(x -> queue.offer(x));

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int i = 0;
        int result = 0;
        while (i < arr.length) {
            int removeCnt = 0;
            while (queue.element() != arr[i]) {
                int data = queue.remove();
                queue.add(data);
                removeCnt++;
            }

            queue.remove();

            if (removeCnt > N / 2) {
                result += N - removeCnt;
            } else {
                result += removeCnt;
            }
            i++;
            N--;
        }

        System.out.println(result);
    }
}
