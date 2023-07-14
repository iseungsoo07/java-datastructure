package hashmap;

// Practice3
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable {

    MyHashTable3(int size) {
        super(size);
    }

    public void setValue(int key, int value) {
        int idx = getHash(key);

        if (elemCnt == table.length) {
            System.out.println("Hash table is full!");
            return;
        } else if (table[idx] == null) {
            table[idx] = value;
        } else {
            int newIdx = idx;
            int cnt = 0;
            while (true) {
                newIdx = (newIdx + (int) Math.pow(2, cnt)) % table.length;
                if (table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            table[newIdx] = value;
        }
        elemCnt++;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}
