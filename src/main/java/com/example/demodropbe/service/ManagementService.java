package com.example.demodropbe.service;

import com.example.demodropbe.dto.ManagementDto;
import com.example.demodropbe.model.Management;

import java.util.List;

public interface ManagementService {
    public List<ManagementDto> getManagement();
    public Management createManagement(ManagementDto managementDto);
}
