package com.guergen.sandbox.repositories.mongodb;

import com.guergen.sandbox.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {
}
