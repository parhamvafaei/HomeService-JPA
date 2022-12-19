package org.maktab.entity.person;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.maktab.entity.Credit;
import org.maktab.entity.Order;


import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client extends Person {

    @OneToOne
private Credit credit;

    @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orders;
}
