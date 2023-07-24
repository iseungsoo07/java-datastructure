package 비선형자료구조.tree;

// Practice1
// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int idx) {
        System.out.print(arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < arr.length) {
            preOrder(left);
        }

        if (right < arr.length) {
            preOrder(right);
        }
    }

    public void inOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < arr.length) {
            inOrder(left);
        }

        System.out.print(arr[idx] + " ");

        if (right < arr.length) {
            inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < arr.length) {
            postOrder(left);
        }

        if (right < arr.length) {
            postOrder(right);
        }

        System.out.print(arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
