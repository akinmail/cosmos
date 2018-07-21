package com.cosmos.hack.controller;

import com.cosmos.hack.model.ImportProcess;
import com.cosmos.hack.repository.ImportProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/importprocess")
public class ImportProcessController extends AbstractController<ImportProcess,String> {

    @Autowired
    public ImportProcessController(ImportProcessRepository repo) {
        super(repo);
    }
}