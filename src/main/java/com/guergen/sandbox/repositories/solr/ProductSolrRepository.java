package com.guergen.sandbox.repositories.solr;

import com.guergen.sandbox.documents.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSolrRepository extends SolrCrudRepository<Product, String> {
}
