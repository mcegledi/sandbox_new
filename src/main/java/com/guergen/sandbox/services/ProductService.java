package com.guergen.sandbox.services;

import com.guergen.sandbox.documents.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product get(final String productId);

    Product create();
    Product create(final String productName);

    void save(Product product);
}
