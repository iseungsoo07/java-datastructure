package 비선형자료구조.연습문제2;

import java.util.ArrayList;
import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;
    ArrayList<Character> capitals;

    public Trie() {
        this.root = new Node();
        this.capitals = new ArrayList<>();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                capitals.add(c);
            }

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;
        ArrayList<Character> cap = new ArrayList<>(capitals);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cap.remove(new Character(c));
                cur = cur.child.get(c);
            } else {
                if (c >= 'A' && c <= 'Z') {
                    return false;
                } else {
                    continue;
                }
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return cap.size() == 0;
    }
}

public class Practice5 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        Trie trie = new Trie();
        trie.insert(pattern);

        ArrayList<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(trie.search(query));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }
}
