package org.example.shopmethodology.controller;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.service.ProviderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
}

