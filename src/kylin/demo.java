package kylin;


import java.util.*;

public class demo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 6);
        map.put(2, 7);
        map.put(3, 5);
        map.put(4, 0);
        map.put(5, 8);
        map.put(6, 1);
        map.put(7, 0);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(
                e -> System.out.println(e.getKey())
        );

    }



}
