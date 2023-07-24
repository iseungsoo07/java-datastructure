package 선형자료구조.linkedlist;

// Practice2
// 양방향 연결 리스트 (Doubly Linked List) 구현

class NodeBi {
    int data;
    NodeBi prev;
    NodeBi next;

    public NodeBi() {

    }

    public NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList {
    NodeBi head;
    NodeBi tail;

    public DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addData(int data, Integer beforeData) {
        if (head == null) {
            head = new NodeBi(data, null, null);
            tail = head;
        } else if (beforeData == null) {
            tail.next = new NodeBi(data, null, tail);
            tail = tail.next;
        } else {
            NodeBi cur = head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == head) {
                        head = new NodeBi(data, head, null);
                        head.next.prev = head;
                    } else {
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        NodeBi cur = head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == head && cur == tail) {
                    head = null;
                    tail = null;
                } else if (cur == head) {
                    head = cur.next;
                    head.prev = null;
                } else if (cur == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        NodeBi cur = head;

        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void showDataFromTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        NodeBi cur = tail;

        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}


public class Practice2 {
    public static void main(String[] args) {


        // Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();          // 1

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();          // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail();  // 5 500 4 400 3 300 2 200 1 100

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
        myList.showDataFromTail();  // List is empty!
    }
}
