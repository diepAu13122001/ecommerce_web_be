package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "`address`")
public class Address extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ward_id", referencedColumnName = "id")
    private Ward ward;

    private String address;


}
