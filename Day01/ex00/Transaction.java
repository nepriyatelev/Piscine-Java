import java.util.UUID;

public class Transaction {
    enum TransferCategory {
        DEBITS,
        CREDITS
    }
    private final UUID identifier;
    private final User recipient;
    private final User sender;
    private final TransferCategory transferCategory;
    private int transferAmount;

    public Transaction(User recipient, User sender, TransferCategory transferCategory, int transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferAmount = transferAmount;
        if (transferCategory == TransferCategory.DEBITS && transferAmount > 0 && sender.getBalance() >= transferAmount) {
            recipient.setBalance(recipient.getBalance() + transferAmount);
            sender.setBalance(sender.getBalance() - transferAmount);
        } else if (transferCategory == TransferCategory.CREDITS && transferAmount < 0 && recipient.getBalance() >= transferAmount) {
            recipient.setBalance(recipient.getBalance() - transferAmount);
            sender.setBalance(sender.getBalance() + transferAmount);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "identifier=" + identifier +
                ", recipient=" + recipient +
                ", sender=" + sender +
                ", transferCategory=" + transferCategory +
                ", transferAmount=" + transferAmount +
                '}';
    }
}
