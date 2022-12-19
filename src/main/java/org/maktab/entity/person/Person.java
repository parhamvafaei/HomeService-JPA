package org.maktab.entity.person;


import jakarta.persistence.*;
import lombok.*;
import org.maktab.base.entity.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    @Email  @Column(unique = true)
    private String email;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8}")
    @Column(nullable = false)
    private String password;


}
