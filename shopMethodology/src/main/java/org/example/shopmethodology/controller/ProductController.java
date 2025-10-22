package org.example.shopmethodology.controller;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
}

