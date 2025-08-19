package LRU_Cache;

public class LRUCacheMain {
    public static void main(String[] args)
    {
        LRUCache<String,Integer> lruCache = new LRUCache<>(3);
        lruCache.put("Tushar",24);
        lruCache.put("Ayush",26);
        lruCache.put("Aman",25);
        System.out.println(lruCache.get("Tushar"));
        lruCache.put("Ankit",25);
        System.out.println(lruCache.get("Ayush")); // should be evicted as capacity is 3
    }
}
