public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        User user1 = new User("Ben", 100);
        User user2 = new User("Helen", 200);
        User user3 = new User("Jack", 300);
        User user4 = new User("Bony", 400);
        User user5 = new User("Mike", 500);
        User user6 = new User("Lana", 600);
        User user7 = new User("Tupac", 700);
        User user8 = new User("Riley", 800);
        User user9 = new User("John", 900);
        User user10 = new User("Howard", 1000);

        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());
        System.out.println(user4.getIdentifier());
        System.out.println(user5.getIdentifier());
        System.out.println(user6.getIdentifier());
        System.out.println(user7.getIdentifier());
        System.out.println(user8.getIdentifier());
        System.out.println(user9.getIdentifier());
        System.out.println(user10.getIdentifier());

        UsersArrayList usersArrayList = new UsersArrayList();
        usersArrayList.add(user1);
        usersArrayList.add(user2);
        usersArrayList.add(user3);
        usersArrayList.add(user4);
        usersArrayList.add(user5);
        usersArrayList.add(user6);
        usersArrayList.add(user7);
        usersArrayList.add(user8);
        usersArrayList.add(user9);
        usersArrayList.add(user10);

        System.out.println();
        for (int i = 0; i < usersArrayList.getArrUsers().length; i++) {
            if (usersArrayList.getArrUsers()[i] != null)
                System.out.println("From arrUsers " + usersArrayList.getArrUsers()[i].getIdentifier());
        }
        System.out.println("arrUsers length " + usersArrayList.getArrUsers().length);

        User user11 = new User("Helen", 1100);
        User user12 = new User("Stu", 1200);
        User user13 = new User("Iren", 1300);
        System.out.println(user11.getIdentifier());
        System.out.println(user12.getIdentifier());
        System.out.println(user13.getIdentifier());
        usersArrayList.add(user11);
        usersArrayList.add(user12);
        usersArrayList.add(user13);
        for (int i = 0; i < usersArrayList.getArrUsers().length; i++) {
            if (usersArrayList.getArrUsers()[i] != null)
                System.out.println("From arrUsers " + usersArrayList.getArrUsers()[i].getIdentifier());
        }
        System.out.println("arrUsers length " + usersArrayList.getArrUsers().length);

        System.out.println(usersArrayList.getById(11).getIdentifier());
        System.out.println(usersArrayList.getById(12).getIdentifier());
        System.out.println(usersArrayList.getById(13).getIdentifier());
//        try {
//            System.out.println(usersArrayList.getById(14).getIdentifier());
//        } catch (UserNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println(usersArrayList.getByIndex(1).getIdentifier());
        System.out.println(usersArrayList.getNumberOfUsers());
    }
}
