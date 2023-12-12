package lesson36;

import lesson36.dto.User;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetExample {

    public static void main(String[] args) {
        Set<String> sphetapore = Set.of("green", "yellow", "red");
        System.out.println(sphetapore);

        Set<String> sphetapore2 = new HashSet<>(Set.of("green", "yellow", "red"));
        sphetapore2.add("green");
        System.out.println(sphetapore2);

        Set<User> users = new HashSet<>(3);
        users.add(new User(1L, "Vitaliy"));
        users.add(new User(2L, "Petr"));
        users.add(new User(3L, "Olga"));
        System.out.println(users);

        Set<User> users2 = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        users2.add(new User(1L, "Vitaliy"));
        users2.add(new User(2L, "Petr"));
        users2.add(new User(3L, "Olga"));
        System.out.println(users2);

        CopyOnWriteArraySet<String> strings = new CopyOnWriteArraySet<>();
    }
}

