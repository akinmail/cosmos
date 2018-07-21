package com.cosmos.hack.controller;

import com.cosmos.hack.model.Shipment;
import com.cosmos.hack.repository.ImportProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class SchedulerController {
    @Autowired
    ImportProcessRepository importProcessRepository;

    @GetMapping()
    public List<Shipment> getAll() {
        return importProcessRepository.findAll().stream()
                .filter(elt -> elt.getShipment() != null)
                .filter(elt -> elt.getShipment().isDocumentComplete() != false)
                .map(elt -> elt.getShipment())
                .collect(Collectors.toList());
    }
}
