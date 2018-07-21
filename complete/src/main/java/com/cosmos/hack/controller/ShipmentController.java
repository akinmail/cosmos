package com.cosmos.hack.controller;

import com.cosmos.hack.exception.ResourceNotFoundException;
import com.cosmos.hack.model.ImportProcess;
import com.cosmos.hack.model.Shipment;
import com.cosmos.hack.repository.ImportProcessRepository;
import com.cosmos.hack.repository.ShipmentProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/shipment")
public class ShipmentController  {

    @Autowired
    ImportProcessRepository importProcessRepository;

    @RequestMapping(value="/{processid}", method=RequestMethod.GET)
    public Shipment getShipment(@PathVariable String processid) {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        if(importProcess.isPresent()){
            return importProcess.get().getShipment();
        }else {
            throw new ResourceNotFoundException("process id not found");
        }
    }

    @GetMapping()
    public List<Shipment> getAll() {
        return importProcessRepository.findAll().stream()
                .filter(elt -> elt.getShipment() != null)
                .map(elt -> elt.getShipment())
                .collect(Collectors.toList());
    }

    @RequestMapping(value="/{processid}", method=RequestMethod.POST)
    public void updateShipment(@PathVariable String processid, @RequestBody Shipment shipment) {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        if(importProcess.isPresent()){
            List<String> names = Arrays.stream(Shipment.class.getDeclaredFields())
                    .map(m->m.getName())
                    .collect(Collectors.toList());
            if(importProcess.get().getShipment() !=null){
                importProcess.get().getShipment().setDocumentComplete(!checkFieldsIsNull(Shipment.class, names));
            }


            ImportProcess ip = importProcess.get();
            Shipment newShipment = new Shipment();
            newShipment.copy(shipment);
            ip.setShipment(newShipment);
            importProcessRepository.save(ip);
        }else {
            throw new ResourceNotFoundException("process id not found");
        }
    }

    public boolean checkFieldsIsNull(Object instance, List<String> fieldNames) {

        return fieldNames.stream().allMatch(field -> {
            try {
                return Objects.isNull(instance.getClass().getDeclaredField(field).get(instance));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                return true;//You can throw RuntimeException if need.
            }
        });
    }
}
