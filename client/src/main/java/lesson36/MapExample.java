package lesson36;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, String> regions = new HashMap<>();
        regions.put(63, "Samara");
        regions.put(77, "Moscow");
        regions.put(78, "Saint-Petersburg");
        regions.put(100, null);
        regions.put(63, "Samara region");
        System.out.println(regions);

        System.out.println(regions.get(62));

        String key = regions.get(100);
//        if (key == null) { //
        if (!regions.containsKey(100)) { //
            System.out.println("no such value exists!");
        }
        System.out.println("----");
        for (Map.Entry<Integer, String> entry : regions.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();


        Map<Integer, String> namesDictionary = Map.of(1, "Maxim", 2, "Vitaly");
        int key1 = 1;
        String value = "Maxim";
        if (namesDictionary.containsKey(key1)) {
            String name = namesDictionary.getOrDefault(1, "");
            if (value.equals(name)) {

            }
        }
//        boolean hasVitaly = namesDictionary.containsValue("Vitaly");

    }
}

