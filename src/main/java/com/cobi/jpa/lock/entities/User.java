package com.cobi.jpa.lock.entities;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.List;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "age")
    private int age;

//    @OneToMany(mappedBy = "user")
//    private List<Phone> phone;

    public void addAge(){
        age = age + 1;
    }
}
