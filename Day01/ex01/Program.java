public class Program {
    public static void main(String[] args) {
        User user1 = new User("Ben", 100);
        User user2 = new User("Helen", 200);
        User user3 = new User("Jack", 300);
        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());
    }
}
