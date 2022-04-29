package com.example.demodropbe.service;

import com.example.demodropbe.dto.ManagementDto;
import com.example.demodropbe.model.Management;
import com.example.demodropbe.repository.ManagementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService{

    private final ManagementRepository repos;


    public ManagementServiceImpl(ManagementRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<ManagementDto> getManagement() {
        List<Management> lm = this.repos.findAll();
        List<ManagementDto> management = new ArrayList<>();

        lm.forEach(m -> management.add(new ManagementDto(m.getId(),m.getFirstName(),m.getLastName(),m.getAdres(),m.getPostcode(),m.getCity(),m.getCountry(),m.getEmail(),m.getUsername(),m.getPassword())));

        return management;
    }

    @Override
    public Management createManagement(ManagementDto managementDto) {
        Management m = new Management();
        m.setFirstName(managementDto.getFirstName());
        m.setLastName(managementDto.getLastName());
        m.setAdres(managementDto.getAdres());
        m.setPostcode(managementDto.getPostcode());
        m.setCity(managementDto.getCity());
        m.setCountry(managementDto.getCountry());
        m.setEmail(managementDto.getEmail());
        m.setUsername(managementDto.getUsername());
        m.setPassword(managementDto.getPassword());
        return this.repos.save(m);
    }
}
