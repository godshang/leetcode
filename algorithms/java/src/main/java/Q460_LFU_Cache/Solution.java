package q460_lfu_cache;

public class Solution {

    public static void main(String[] args) {
//        LFUCache lFUCache = new LFUCache(2);
//        lFUCache.put(1, 1);
//        lFUCache.put(2, 2);
//        System.out.println(lFUCache.get(1));      // 返回 1
//        lFUCache.put(3, 3);   // 去除键 2
//        System.out.println(lFUCache.get(2));      // 返回 -1（未找到）
//        System.out.println(lFUCache.get(3));      // 返回 3
//        lFUCache.put(4, 4);   // 去除键 1
//        System.out.println(lFUCache.get(1));      // 返回 -1（未找到）
//        System.out.println(lFUCache.get(3));      // 返回 3
//        System.out.println(lFUCache.get(4));      // 返回 4
        
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }
}
