package by.tms.petstorejpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @NotBlank
    @NotEmpty
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
    private PetStatus petStatus;

}
