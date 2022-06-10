public interface UsersList {
    void add(User object);
    User getById(Integer identifier) throws UserNotFoundException;
    User getByIndex(Integer index);
    Integer getNumberOfUsers();
}
