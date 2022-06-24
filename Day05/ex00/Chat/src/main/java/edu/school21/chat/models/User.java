package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String login;
    private String password;

    private List<Chatroom> chatRooms = new ArrayList<>();

    private List<Message> messages = new ArrayList<>();

    public User() {
    }

    public User(long id, String login, String password, List<Chatroom> chatRooms, List<Message> messages) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.chatRooms = chatRooms;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getChatRooms() {
        return chatRooms;
    }

    public void setChatRooms(List<Chatroom> chatRooms) {
        this.chatRooms = chatRooms;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(chatRooms, user.chatRooms) && Objects.equals(messages, user.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, chatRooms, messages);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", chatRooms=" + chatRooms +
                ", messages=" + messages +
                '}';
    }
}
