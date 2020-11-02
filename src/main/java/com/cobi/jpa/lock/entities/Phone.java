package com.cobi.jpa.lock.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "phone")
@Entity
public class Phone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private User user;
}
