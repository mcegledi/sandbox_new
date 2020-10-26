package com.guergen.sandbox;

import com.guergen.sandbox.services.ProductService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
@Configuration
public class SandboxApplication implements CommandLineRunner {

    private ProductService productService;

//    public SandboxApplication(@Qualifier("fredTheFriendlyProductServiceBean") ProductService productService) {
//        this.productService = productService;
//    }

    public static void main(String[] args) {

        SpringApplication.run(SandboxApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Here the beans would be printed...");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName : beanNames) {
                //System.out.println(beanName);
            }

            //System.out.println(ctx.getBean("fredTheFriendlyServiceBean").getClass().toString());

            //productService.create("Produkt beim Startprozess erzeugt");
        };
    }

    @Override
    public void run(String... args) throws Exception {

        //productService.create("Produkt beim Startprozess erzeugt");
    }

}
