package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Message {
    private long id;
    private User user;
    private Chatroom chatroom;
    private String message;
    private LocalDateTime time;

    public Message() {
    }

    public Message(long id, User user, Chatroom chatroom, String message, LocalDateTime time) {
        this.id = id;
        this.user = user;
        this.chatroom = chatroom;
        this.message = message;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id == message1.id && Objects.equals(user, message1.user) && Objects.equals(chatroom, message1.chatroom) && Objects.equals(message, message1.message) && Objects.equals(time, message1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, chatroom, message, time);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", chatroom=" + chatroom +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}


