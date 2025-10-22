package com.example.shop.controller;

import com.example.shop.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
}
