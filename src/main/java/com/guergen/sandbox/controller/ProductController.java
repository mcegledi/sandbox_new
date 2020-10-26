package com.guergen.sandbox.controller;

import com.guergen.sandbox.documents.Product;
import com.guergen.sandbox.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@ComponentScan
@Controller("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("mongoProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/getAll")
    public String getAll(Model model) {

        List<Product> all = productService.getProducts();
        model.addAttribute("allProducts", all);

        return "product/getAll";
    }


    @PostMapping("product/add")
    public String storeProduct(@ModelAttribute Product product) {

        productService.save(product);
        return "redirect:/product/getAll";
    }

    @GetMapping({"/product/edit/{id}", "/product/add"})
    public String editProduct(Model model, @PathVariable(name = "id", required = false) String productId) {
        model.addAttribute("productForm", productService.get(productId));
        return "/product/addOrEdit";
    }
}
