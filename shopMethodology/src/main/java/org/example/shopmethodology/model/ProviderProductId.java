package org.example.shopmethodology.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProviderProductId implements Serializable {
    private static final long serialVersionUID = 760012617012146136L;
    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProviderProductId entity = (ProviderProductId) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.providerId, entity.providerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, providerId);
    }

}