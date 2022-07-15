public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "Denis", 500);
        User user2 = new User(2, "Maks", 400);
        System.out.println(user1+"\n"+user2);
        Transaction transaction1 = new Transaction(user1, user2, Transaction.TransferCategory.CREDITS, -400);
        System.out.println(transaction1);
        Transaction transaction2 = new Transaction(user2, user1, Transaction.TransferCategory.DEBITS, 900);
        System.out.println(transaction2);
    }
}
