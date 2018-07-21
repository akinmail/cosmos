package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Bol;
import com.cosmos.hack.repository.document.BolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/bol")
public class BolController extends AbstractController<Bol,String> {
    @Autowired
    public BolController(BolRepository repo) {
        super(repo);
    }
}
