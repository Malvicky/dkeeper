package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ServiceProvidedDto;
import com.dkeeper.dkeeper.model.ServiceProvided;
import com.dkeeper.dkeeper.repository.ServiceProvidedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceProvidedService {
    private final ServiceProvidedRepository serviceProvidedRepository;
public String addServiceProvided(ServiceProvidedDto load){
    ServiceProvided serviceProvided = new ServiceProvided();
    serviceProvided.setCodeId(load.getCodeId());
    serviceProvided.setServiceId(load.getServiceId());
    serviceProvided.setPriceFinal(load.getPriceFinal());
    serviceProvidedRepository.save(serviceProvided);
    return "On our way";

}
}
