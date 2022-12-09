package org.maktab.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.maktab.base.entity.BaseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Credit extends BaseEntity {
    private Double amount;
}
