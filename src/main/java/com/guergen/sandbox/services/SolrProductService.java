package com.guergen.sandbox.services;

import com.guergen.sandbox.documents.Product;
import com.guergen.sandbox.repositories.solr.ProductSolrRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ComponentScan
@Service
@Qualifier("solrProductService")
public class SolrProductService extends CommonProductService implements ProductService {

    @Setter(onMethod = @__(@Autowired))
    private ProductSolrRepository productSolrRepository;

    @Override
    public List<Product> getProducts() {

        return StreamSupport.stream(productSolrRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Product get(String productId) {
        Optional<Product> optionalProduct = productSolrRepository.findById(productId);
        return optionalProduct.orElse(create());
    }

    @Override
    public void save(Product product) {
        productSolrRepository.save(product);
    }
}
