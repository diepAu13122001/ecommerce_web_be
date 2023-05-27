package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import javax.transaction.Transactional;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`ward`")
public class Ward extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;



}
