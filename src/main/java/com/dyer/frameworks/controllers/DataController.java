package com.dyer.frameworks.controllers;

import com.dyer.frameworks.domain.DataResult;
import com.dyer.frameworks.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/data/{identifier}")
    public List<DataResult> getData(@PathVariable Integer identifier) {
        return dataService.getDataById(identifier);
    }

}
