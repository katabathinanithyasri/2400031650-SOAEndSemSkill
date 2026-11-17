package com.klu.springmvc.controller;



import com.klu.springmvc.model.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/data")
    public List<Data> getData() {
        return jdbc.query(
            "SELECT id, message FROM data",
            (rs, rowNum) -> {
                Data d = new Data();
                d.setMessage(rs.getString("message"));
                return d;
            }
        );
    }
}