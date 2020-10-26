package com.guergen.sandbox.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.UUID;

@Data
@SolrDocument(collection = "sandbox")
@Document(collection = "product")
public class Product {

    @Id
    @Indexed(name="id", type = "string")
    private final String productId;

    @Indexed(name = "name", type = "string")
    private String productName;

//
//    public Product(final String productName) {
//
//        this.productId = UUID.randomUUID().toString();
//        this.productName = productName;
//    }
//
//    public Product() {
//        this.productId = UUID.randomUUID().toString();
//    }
}
