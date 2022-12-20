package org.maktab.entity.person;

import jakarta.persistence.Entity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Admin extends Person {

}
