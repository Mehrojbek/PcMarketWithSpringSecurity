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
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "comment should not be null")
    private String comment;

    @NotNull(message = "name should not be null")
    private String name;

    @NotNull(message = "email should not be null")
    private String email;

    @ManyToOne
    private Product product;

}
