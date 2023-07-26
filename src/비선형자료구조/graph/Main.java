package 비선형자료구조.graph;

// 비선형 자료구조 - 그래프
// 인접 행렬을 이용한 그래프 구현

class MyGraphMatrix {
    char[] vertices;
    int[][] adjMat;
    int elemCnt;

    public MyGraphMatrix() {

    }

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return elemCnt == vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        vertices[elemCnt++] = data;
    }

    // 무방향 그래프 간선
    public void addEdge(int x, int y) {
        adjMat[x][y] = 1;
        adjMat[y][x] = 1;
    }

    // 방향 그래프 간선
    public void addDirectionEdge(int x, int y) {
        adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        adjMat[x][y] = 0;
        adjMat[y][x] = 0;
    }

    public void deleteDirectionEdge(int x, int y) {
        adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char item : vertices) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < elemCnt; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < elemCnt; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        // Test code
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();
    }
}
