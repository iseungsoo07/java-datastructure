package hashmap;

// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c;

    MyHashTable4(int size) {
        super(size);
        this.c = getHashC(size);
    }

    public int getHashC(int size) {
        int c = 0;

        if (size <= 2) {
            return size;
        }

        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                c = i;
                break;
            }
        }
        return c;
    }

    public int getHash2(int key) {
        return 1 + key % this.c;
    }

    public void setValue(int key, int value) {
        int idx = getHash(key);

        if (elemCnt == table.length) {
            System.out.println("Hash Table is full!");
            return;
        } else if (table[idx] == null) {
            table[idx] = value;
        } else {
            int newIdx = idx;
            int cnt = 1;
            while (true) {
                newIdx = (newIdx + getHash2(newIdx) * cnt) % table.length;
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

public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
