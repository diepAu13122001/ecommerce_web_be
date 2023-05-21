package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`role`")
@Data
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "id")
    private String id;

    private String roleName;


}
