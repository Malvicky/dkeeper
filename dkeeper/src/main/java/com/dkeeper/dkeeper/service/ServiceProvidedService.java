package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ServiceProvidedDto;
import com.dkeeper.dkeeper.repository.ServiceProvidedRepository;
import com.dkeeper.dkeeper.model.ServiceProvided;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProvidedService {
    private final ServiceProvidedRepository serviceProvidedRepository;

    @Autowired
    public ServiceProvidedService(ServiceProvidedRepository serviceProvidedRepository) {
        this.serviceProvidedRepository = serviceProvidedRepository;
    }

    public ServiceProvidedDto createService(ServiceProvidedDto serviceProvidedDto) {
        ServiceProvided serviceProvided = new ServiceProvided();
        serviceProvided.setCodeId(serviceProvidedDto.getCodeId());
        serviceProvided.setEmployeeId(serviceProvidedDto.getEmployeeId());
        serviceProvided.setServiceProvided(serviceProvidedDto.getServiceProvided());
        serviceProvided.setPriceFinal(serviceProvidedDto.getPriceFinal());

        ServiceProvided savedService = serviceProvidedRepository.save(serviceProvided);
        return convertToDto(savedService);
    }

    public List<ServiceProvidedDto> getAllServices() {
        List<ServiceProvided> services = serviceProvidedRepository.findAll();
        return services.stream()
                .map(this::convertToDto)
                .toList();
    }

    public Optional<ServiceProvidedDto> getServiceById(String codeId) {
        return serviceProvidedRepository.findById(codeId)
                .map(this::convertToDto);
    }

    public ServiceProvidedDto updateService(String codeId, ServiceProvidedDto serviceProvidedDto) {
        ServiceProvided serviceProvided = serviceProvidedRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        serviceProvided.setEmployeeId(serviceProvidedDto.getEmployeeId());
        serviceProvided.setServiceProvided(serviceProvidedDto.getServiceProvided());
        serviceProvided.setPriceFinal(serviceProvidedDto.getPriceFinal());

        ServiceProvided updatedService = serviceProvidedRepository.save(serviceProvided);
        return convertToDto(updatedService);
    }

    public void deleteService(String codeId) {
        serviceProvidedRepository.deleteById(codeId);
    }

    private ServiceProvidedDto convertToDto(ServiceProvided serviceProvided) {
        ServiceProvidedDto dto = new ServiceProvidedDto();
        dto.setCodeId(serviceProvided.getCodeId());
        dto.setEmployeeId(serviceProvided.getEmployeeId());
        dto.setServiceProvided(serviceProvided.getServiceProvided());
        dto.setPriceFinal(serviceProvided.getPriceFinal());
        return dto;
    }
}