package org.maktab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.maktab.base.entity.BaseEntity;
import org.maktab.entity.person.Client;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order extends BaseEntity {

    private Double price;
    private String description;
    private LocalDateTime time;
    private Boolean isDone;

    @ManyToOne
    private Address address;

    @ManyToOne
    private SubService subService;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Offer> offer;


    @Enumerated
    private OrderStatus orderStatus = OrderStatus.WAITING_FOR_EXPERT;


}
