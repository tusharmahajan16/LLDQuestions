package hashmap_implementation.java;

public class MapImpl {
    public static void main(String[] args) {
        CustomMap<String,Integer> mp = new CustomMap<>();
        mp.put("Tushar", 6);
        mp.put("two", 3);
        mp.put("three", 5);
        mp.put("four", 4);
        mp.put("five", 4);

        System.out.println(mp.get("five"));
        System.out.println(mp.get("four"));
        System.out.println(mp.get("Tushar"));
        System.out.println(mp.get("two"));
        System.out.println(mp.get("three"));
        System.out.println(mp.get("Seven"));
    }
}
