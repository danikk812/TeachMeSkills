package by.sokol.home.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    private int id;

    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters!")
    @Pattern(regexp = "^([A-Z]?[a-z]{2,14})$",
            message = "Only characters must be here!")
    private String name;

    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters!")
    @Pattern(regexp = "^(\\w{3,15})$",
            message = "Only characters and digits must be here!")
    private String login;


    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters!")
    @Pattern(regexp = "^(\\w{3,15})$",
            message = "Only characters and digits must be here!")
    private String password;

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

