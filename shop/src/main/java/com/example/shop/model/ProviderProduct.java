package com.example.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "provider_product")
@Data
public class ProviderProduct implements Serializable {

    @EmbeddedId
    private ProviderProductPK id;

    @ManyToOne
    @MapsId("providerId")
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

}
