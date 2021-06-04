package by.sokol.home.entity.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDTO {

    private int id;

    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters!")
    @Pattern(regexp = "^(\\w{3,15})$",
            message = "Only letters and numbers must be here!")
    private String login;


    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters!")
    @Pattern(regexp = "^(\\w{3,15})$",
            message = "Only letters and numbers must be here!")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDTO(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(login, userDTO.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}

