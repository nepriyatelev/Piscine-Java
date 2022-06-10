public class UsersArrayList implements UsersList {
    private User[] arrUsers = new User[10];
    private static int length = 10;
    private static int i = 0;

    @Override
    public void add(User object) {
        for (; i < length; i++) {
            if (arrUsers[i] == null) {
                arrUsers[i] = object;
                break;
            }
        }
        if (i == length) {
            length *= 2;
            i = 0;
            User[] tmpArrUsers = new User[length];
            for (; i < length / 2; i++) {
                tmpArrUsers[i] = arrUsers[i];
            }
            tmpArrUsers[i] = object;
            this.arrUsers = tmpArrUsers;
        }
    }

    @Override
    public User getById(Integer identifier) throws UserNotFoundException {
        for (int j = 0; j < i + 1; j++) {
            if (arrUsers[j].getIdentifier() == identifier)
                return arrUsers[j];
        }
        throw new UserNotFoundException("User with Id:" + identifier + " doesn't exist");
    }

    @Override
    public User getByIndex(Integer index) {
        return arrUsers[index];
    }

    @Override
    public Integer getNumberOfUsers() {
        return i + 1;
    }

    public User[] getArrUsers() {
        return arrUsers;
    }
}
