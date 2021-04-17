package uz.pdp.apppcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "fullName should not be null")
    private String fullName;

    @NotNull(message = "role should not be null")
    private String role;

    @NotNull(message = "attachment should not be null")
    @OneToOne
    private Attachment attachment;
}
