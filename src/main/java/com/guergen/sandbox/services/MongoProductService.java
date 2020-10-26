package com.guergen.sandbox.services;

import com.guergen.sandbox.documents.Product;
import com.guergen.sandbox.repositories.mongodb.ProductMongoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("mongoProductService")
public class MongoProductService extends CommonProductService implements ProductService {

    @Setter(onMethod = @__(@Autowired))
    ProductMongoRepository productMongoRepository;

    @Override
    public List<Product> getProducts() {

        return new ArrayList<>(productMongoRepository.findAll());
    }

    @Override
    public Product get(String productId) {
        if(productId == null || productId.isEmpty()) {
            return create();
        }
        return productMongoRepository.findById(productId).orElse(create());
    }

    @Override
    public void save(Product product) {
        productMongoRepository.save(product);
    }
}
