package com.backend.ecommerceweb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`payment_method`")
public class PaymentMethod extends BaseEntity{
    private String name;
    private String imgUrl;
    private Double minTransfer;
    private Double maxTransfer;
}
