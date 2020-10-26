package com.guergen.sandbox;

import com.guergen.sandbox.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializationListener implements ApplicationListener<ApplicationReadyEvent> {


    private ProductService productService;

    public ApplicationInitializationListener(@Qualifier("mongoProductService")ProductService productService) {
        this.productService = productService;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        productService.create("Foo, mahcen wir hier");
    }
}
