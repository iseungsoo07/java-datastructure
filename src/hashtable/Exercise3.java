package hashtable;

// Exercise3
// 참고 - Hashtable? HashMap?

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Exercise3 {
    public static void main(String[] args) {
        // Hashtable
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0));

        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0));

        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;

        System.out.println(map1.get(0));
        System.out.println(map2.get(0));

        // ht.put(null, -999);
        // System.out.println(ht.get(null));

        hm.put(null, -999);
        System.out.println(hm.get(null));

        // HashMap과 Hashtable의 차이
        // 공통 : 둘 다 Map 인터페이스를 구현한 것
        // 차이
        // 1. Key에 null을 사용할 수 있는지? -> Hashtable은 사용 불가, HashMap은 사용 가능
        // 2. Thread-safe 측면에서 Hashtable은 safe하기 때문에 멀티 스레드 환경에서 우수
        //                       HashMap은 safe하지 않기 때문에 싱글 스레드 환경에서 우수 (synchrionizedMap, ConcurrentHashMap 을 사용해서 해결)
    }
}
