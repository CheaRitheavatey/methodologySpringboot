package com.example.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProviderProductPK implements Serializable {

    private Long providerId;
    private Long productId;

}
