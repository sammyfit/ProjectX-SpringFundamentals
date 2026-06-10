package com.codingshuttle.jpatutorial.controllers;

import com.codingshuttle.jpatutorial.entities.ProductEntity;
import com.codingshuttle.jpatutorial.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE=5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //http://localhost:8080/products?sortBy=quantity&pageNumber=0
    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber) {
        //return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy),Sort.Order.desc("title")));

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));

        //http://localhost:8080/products?sortBy=quantity&pageNumber=0
        return productRepository.findAll(pageable).getContent();
    }

    //http://localhost:8080/products/secondMethod?sortBy=quantity&pageNumber=0&title=desk
    @GetMapping("/secondMethod")
    public List<ProductEntity> getAllProducts2(
                                              @RequestParam(defaultValue = "") String title,
                                              @RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber) {

        //http://localhost:8080/products/secondMethod?sortBy=quantity&pageNumber=0&title=desk
        return productRepository.findByTitleContainingIgnoreCase(title, PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy)));
    }
}
