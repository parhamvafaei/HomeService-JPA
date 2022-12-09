package org.maktab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.maktab.base.entity.BaseEntity;
import org.maktab.entity.person.Expert;

import java.time.Duration;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Offer extends BaseEntity {
    private Double price;
    private Duration timeDuration ;

    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Order order;
}
