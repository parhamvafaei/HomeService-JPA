package org.maktab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.maktab.base.entity.BaseEntity;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Service extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SubService> subServices;

}
