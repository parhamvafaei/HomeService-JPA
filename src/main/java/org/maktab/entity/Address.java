package org.maktab.entity;

import jakarta.persistence.Entity;

import lombok.*;
import org.maktab.base.entity.BaseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    private String address;
    private Long phoneNumber;


}
