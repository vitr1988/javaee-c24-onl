package lesson31.facade;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientStorage {

    private static final ClientStorage INSTANCE = new ClientStorage();

    public static ClientStorage getInstance() {
        return INSTANCE;
    }

    public String save(Client client) {
        return client.getFullName();
    }
}
