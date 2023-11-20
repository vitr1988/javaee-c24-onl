package lesson31.facade;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockListService {

    private static final BlockListService INSTANCE = new BlockListService();

    private List<Client> stoplist = List.of();

    public boolean isValid(Client client) {
        return !stoplist.contains(client);
    }

    public static BlockListService getInstance() {
        return INSTANCE;
    }
}
