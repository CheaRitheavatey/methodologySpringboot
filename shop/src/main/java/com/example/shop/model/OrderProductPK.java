package com.example.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class OrderProductPK implements Serializable {

    private Long orderId;
    private Long productId;
}
