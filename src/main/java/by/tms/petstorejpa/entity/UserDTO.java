package by.tms.petstorejpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String username;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String password;
}

