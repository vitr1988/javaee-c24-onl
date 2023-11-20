package lesson31.facade;

import java.math.BigDecimal;

public class BankSystem {

    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        Client ivanIvanovich = Client.builder()
                .fullName("Ivan Ivanovich")
                .age(25)
                .sex(true)
                .money(BigDecimal.ZERO)
                .build();
        try {
            loanService.takeCredit(ivanIvanovich);
        }
        catch (IllegalStateException ile) {
            System.out.println("Client " + ivanIvanovich + " can't take loan!");
        }
        loanService.takeCredit(Client.builder()
                .fullName("Maria Ivanovna")
                .age(60)
                .sex(false)
                .money(new BigDecimal(10000))
                .build());
    }
}
