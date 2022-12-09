package org.maktab.entity.person;

import jakarta.persistence.*;
import lombok.*;
import org.maktab.entity.Credit;
import org.maktab.entity.Offer;
import org.maktab.entity.Order;
import org.maktab.entity.SubService;


import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Expert extends Person {

    private Float rating = 0.0F;

    @Lob
    @Size(max = 300_000)
    private byte[] photo;

    @Enumerated
    private ExpertStatus expertStatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "expert_subservice",
            joinColumns = @JoinColumn(name = "expert_id"),
            inverseJoinColumns = @JoinColumn(name = "subservice_id"))
    @ToString.Exclude
    private List<SubService> subServices;

    @OneToMany(mappedBy = "expert" , cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Offer> offers;


    @OneToOne(cascade = CascadeType.ALL)
    private Credit credit;

    public ExpertStatus getStatus() {
        return this.expertStatus;
    }
}
