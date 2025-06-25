package com.altenshop.altenshopback.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
