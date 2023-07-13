package org.nuhaempresario.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Enumerated(value = EnumType.STRING)
    private TodoState status;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Todo(String title, String content, TodoState status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TodoState getStatus() {
        return status;
    }

    public void setStatus(TodoState status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (!Objects.equals(id, todo.id)) return false;
        if (!Objects.equals(title, todo.title)) return false;
        if (!Objects.equals(content, todo.content)) return false;
        if (status != todo.status) return false;
        return Objects.equals(user, todo.user);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
