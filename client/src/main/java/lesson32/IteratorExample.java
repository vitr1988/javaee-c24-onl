package lesson32;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>(List.of("green", "yellow", "red", "orange", "black", "white"));
        for (int i = 0; i < colors.size(); i++) {
            String color = colors.get(i);
            System.out.println(color);
        }
        System.out.println("-------");
        for (Iterator<String> iter = colors.iterator(); iter.hasNext(); ) {
            String color = iter.next();
            System.out.println(color);
        }
        System.out.println("-------");
        int index = 0;
//        for (String color : colors) {
        for (Iterator<String> iter = colors.iterator(); iter.hasNext(); ) {
            String color = iter.next();
            System.out.println(color);
            if (index++ % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println(colors);
    }
}
