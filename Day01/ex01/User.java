public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(String name, Integer balance) {
        this.name = name;
        this.balance = Integer.max(balance, 0);
        this.identifier = UserIdsGenerator.getInstance().generateId();
    }

    public int getIdentifier() {
        return identifier;
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
