package hashmap;

// 선형 자료구조 - 해시 테이블

import java.util.Hashtable;
import java.util.Map;

public class Main {
    // 해시 함수
    public static int getHash(int key) {
        return key % 5;
    }

    public static void main(String[] args) {
        // 기본 해시 테이블 사용 방법
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        hashtable.put("key1", 10);
        hashtable.put("key2", 20);
        hashtable.put("key3", 30);
        hashtable.put("key3", 50); // 충돌이 발생하면 value가 변경됨

        for (Map.Entry<String, Integer> item : hashtable.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        // 해시 충돌 케이스 (해시 함수 사용)
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(getHash(1), 10);
        ht.put(getHash(2), 20);
        ht.put(getHash(3), 30);
        ht.put(getHash(4), 40);
        ht.put(getHash(5), 50);

        System.out.println("== 충돌 전 ==");

        for (Map.Entry<Integer, Integer> item : ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        ht.put(getHash(6), 60);
        System.out.println("== 충돌 후 ==");

        for (Map.Entry<Integer, Integer> item : ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

    }
}
