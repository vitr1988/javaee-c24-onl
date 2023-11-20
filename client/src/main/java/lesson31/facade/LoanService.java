package lesson31.facade;

import java.math.BigDecimal;

public class LoanService {

    public Credit takeCredit(Client client) {
        if (!BlockListService.getInstance().isValid(client)) {
            throw new IllegalStateException("Client " + client + " can't take the credit because of he/she is in blocklist");
        }
        else if (!VerificationService.getInstance().isValid(client)) {
            throw new IllegalStateException("Client " + client + " can't take the credit because of he/she doesn't match requirements");
        }
        String clientId = ClientStorage.getInstance().save(client);
        return new Credit(clientId, client.getMoney().multiply(new BigDecimal(10)));
    }
}
