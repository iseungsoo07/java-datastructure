package 선형자료구조.연습문제1;

class Node {
    int data; // 풍선의 번호
    int cmd; // 메모에 적힌 수

    boolean visited;
    Node next;
    Node prev;

    public Node(int data, int cmd, boolean visited, Node next, Node prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedListC {
    Node head;

    public void add(int data, int cmd) {
        if (head == null) {
            head = new Node(data, cmd, false, null, null);
            head.next = head;
            head.prev = head;
        } else {
            Node cur = head;
            while (cur.next != head) {
                cur = cur.next;
            }
            cur.next = new Node(data, cmd, false, cur.next, cur);
            head.prev = cur.next;
        }
    }
}

public class Practice3 {
    public static void solution(int[] data) {
        LinkedListC linkedList = new LinkedListC();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i + 1, data[i]);
        }

        Node cur = linkedList.head;
        int visitCnt = 0; // 몇 개가 터졌는지
        int cmd = 0;
        while (visitCnt != data.length) {
            int cnt = 0; // 이동 카운트

            while (cnt != Math.abs(cmd)) {
                if (cmd > 0) {
                    cur = cur.next;
                } else {
                    cur = cur.prev;
                }

                if (!cur.visited) {
                    cnt++;
                }
            }
            System.out.print(cur.data + " ");
            cur.visited = true;
            visitCnt++;
            cmd = cur.cmd;
        }

    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
        System.out.println();
    }
}
