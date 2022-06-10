public class User {
    private String name;
    private Integer identifier;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance >= 0) this.balance = balance;
        this.identifier = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getIdentifier() {
        return identifier;
    }
}
