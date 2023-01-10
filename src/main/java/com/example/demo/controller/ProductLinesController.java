package com.example.demo.controller;

import com.example.demo.service.ProductLinesService;
import com.jooq.model.tables.pojos.Productlines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productLine")
public class ProductLinesController {

    @Autowired
    private ProductLinesService productLinesService;

    @GetMapping
    public List<Productlines> getAll(){
        return productLinesService.getAll();
    }
}
