package linkedlist;

// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data;
    Node next;

    public Node() {

    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {

    }

    public LinkedList(Node node) {
        this.head = node;
    }

    //  연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        return head == null;
    }

    //  연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            Node cur = head;

            while (cur.next != null) {
                cur = cur.next; // 맨 뒤 노드까지 이동
            }

            cur.next = new Node(data, null);
        }


    }

    //  연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = head;
        Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == head) {
            head = null;
        } else {
            prev.next = null;
        }
    }

    //  연결 리스트에서 데이터 찾기
    public boolean findData(int data) {
        if (isEmpty()) {
            // System.out.println("List is empty!");
            return false;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.data == data) {
                // System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        // System.out.println("Data not found!");
        return false;
    }

    //  연결 리스트의 모든 데이터 출력
    public void showData() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}


public class Main {

    public static void main(String[] args) {

        // Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5

        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty

    }

}
