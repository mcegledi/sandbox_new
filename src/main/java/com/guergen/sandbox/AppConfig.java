package com.guergen.sandbox;

import com.guergen.sandbox.services.ProductService;
import com.guergen.sandbox.services.SolrProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductService fredTheFriendlyProductServiceBean() {
        return new SolrProductService();
    }
}
