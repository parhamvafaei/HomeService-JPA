package org.maktab.entity;

import jakarta.persistence.*;

import lombok.*;
import org.maktab.base.entity.BaseEntity;
import org.maktab.entity.person.Expert;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubService extends BaseEntity {

   private String name;
   private Double price;
   private String description;

   @Enumerated
   private Service service;

   @ManyToMany(cascade = CascadeType.ALL)
   @ToString.Exclude
   private List<Expert> experts;

//(mappedBy = "subservice")
//   @OneToMany
//   @ToString.Exclude
//   private List<Order> orders;


}