package com.example.demo.service;

import com.jooq.model.Tables;
import com.jooq.model.tables.pojos.Products;
import com.sun.media.sound.DLSInfo;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.jooq.impl.DSL.count;

@Service
public class ProductService {
    @Autowired
    private DSLContext dslContext;

    public List<Products> getAll(){
        return dslContext.selectFrom(Tables.PRODUCTS).fetchInto(Products.class);
    }

    public Map<String, Integer> countByProductLine(){
        Result<Record2<String, Integer>> rs = dslContext.select(Tables.PRODUCTS.PRODUCTLINE.as("a"), DSL.count(Tables.PRODUCTS.PRODUCTCODE).as("b"))
                .from(Tables.PRODUCTS)
                .groupBy(Tables.PRODUCTS.PRODUCTLINE)
                .fetch();
        System.out.print(rs);
        Map<String, Integer> map1 = new HashMap<>();
        for (Record2<String, Integer> record : rs) {
            map1.put(record.value1(), record.value2());
        }
        return map1;
    }

}
