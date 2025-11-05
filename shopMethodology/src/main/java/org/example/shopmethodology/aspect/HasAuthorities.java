package org.example.shopmethodology.aspect;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE) // highest priority
public @interface HasAuthorities {
    SecurityAuthorities[] authorities();
}
