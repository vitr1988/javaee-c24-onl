package by.teachmeskills.lesson26.service;

import java.util.Map;

public class StorageService {

    private static final Map<Long, String> USERS = Map.of(
            1L, "Vitaly",
            2L, "Petr",
            3L, "Maria",
            4L, "Oxana");

    public String getById(Long id) {
        return USERS.get(id);
    }
}
