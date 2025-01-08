package com.dkeeper.dkeeper.controller;

import com.dkeeper.dkeeper.dto.ServiceProvidedDto;
import com.dkeeper.dkeeper.service.ServiceProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceProvidedController {

    private final ServiceProvidedService serviceProvidedService;

    @Autowired
    public ServiceProvidedController(ServiceProvidedService serviceProvidedService) {
        this.serviceProvidedService = serviceProvidedService;
    }

    @PostMapping
    public ResponseEntity<ServiceProvidedDto> createService(@RequestBody ServiceProvidedDto serviceProvidedDto) {
        ServiceProvidedDto createdService = serviceProvidedService.createService(serviceProvidedDto);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProvidedDto>> getAllServices() {
        List<ServiceProvidedDto> services = serviceProvidedService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{codeId}")
    public ResponseEntity<ServiceProvidedDto> getServiceById(@PathVariable String codeId) {
        Optional<ServiceProvidedDto> service = serviceProvidedService.getServiceById(codeId);
        return service.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{codeId}")
    public ResponseEntity<ServiceProvidedDto> updateService(@PathVariable String codeId,
                                                            @RequestBody ServiceProvidedDto serviceProvidedDto) {
        try {
            ServiceProvidedDto updatedService = serviceProvidedService.updateService(codeId, serviceProvidedDto);
            return ResponseEntity.ok(updatedService);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{codeId}")
    public ResponseEntity<Void> deleteService(@PathVariable String codeId) {
        try {
            serviceProvidedService.deleteService(codeId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}