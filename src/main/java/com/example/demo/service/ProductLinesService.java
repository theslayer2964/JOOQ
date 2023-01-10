package com.example.demo.service;

import com.jooq.model.Tables;
import com.jooq.model.tables.pojos.Productlines;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLinesService {
    @Autowired
    private DSLContext dslContext;

    public List<Productlines> getAll(){
        return dslContext.selectFrom(Tables.PRODUCTLINES).fetchInto(Productlines.class);
    }
}
