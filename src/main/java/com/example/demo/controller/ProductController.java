package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.jooq.model.tables.pojos.Products;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Products> getAll(){
        return productService.getAll();
    }

    @GetMapping("/group")
    public Map<String, Integer> getCount(){
        return productService.countByProductLine();
    }
}
