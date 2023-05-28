package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @Column(name = "id")
    private String id;


    private String roleName;


}
