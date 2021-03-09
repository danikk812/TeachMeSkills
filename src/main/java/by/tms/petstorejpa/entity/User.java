package by.tms.petstorejpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String username;

    @NotBlank
    @NotEmpty
    private String firstName;

    @NotBlank
    @NotEmpty
    private String lastName;

    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String password;

    @NotBlank
    @NotEmpty
    private String phone;
    private int userStatus;
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
