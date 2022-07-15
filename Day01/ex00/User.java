public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(int identifier, String name, int balance) {
        this.identifier = identifier;
        this.name = name;
        this.balance = Integer.max(balance, 0);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
