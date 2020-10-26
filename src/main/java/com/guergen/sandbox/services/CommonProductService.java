package com.guergen.sandbox.services;

import com.guergen.sandbox.documents.Product;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class CommonProductService {

    public String getName() {
        return "CommonProductService";
    }

    public Product create() {
        return new Product(UUID.randomUUID().toString());
    }

    public Product create(final String productName) {
        Product newProduct = create();
        newProduct.setProductName(productName);
        return newProduct;
    }


    @PostConstruct
    void postConstruct() {

        System.out.println("@PostConstruct: " + this.getClass().toString());
    }
}
