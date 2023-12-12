package lesson36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListExample {

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>(List.of("red", "green", "blue", "yellow"));
        colors.add(3, "white");
        System.out.println(colors);

        System.out.println(colors.get(colors.size() - 1));
        System.out.println(colors.indexOf("green"));

        List<Boolean> flags = new LinkedList<>();
        flags.add(false);
        flags.add(true);
        flags.add(true);
        flags.add(false);
        flags.add(null);
        flags.set(flags.size() - 1, false);
        System.out.println(flags);


        List<String> concurrentList = new CopyOnWriteArrayList<>();
        List<String> strings = Collections.synchronizedList(colors);
    }
}

