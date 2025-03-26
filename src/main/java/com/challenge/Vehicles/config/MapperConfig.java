package com.challenge.Vehicles.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.Vehicles.dtos.maintenance.MaintenanceCreateDTO;
import com.challenge.Vehicles.dtos.maintenance.MaintenanceResponseDTO;
import com.challenge.Vehicles.entities.Maintenance;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Maintenance.class, MaintenanceResponseDTO.class)
                .addMappings(mapping -> {
                    mapping.map(maintenance -> maintenance.getVehicle().getLicensePlate(),
                            MaintenanceResponseDTO::setLicensePlate);
                });

        modelMapper.typeMap(MaintenanceCreateDTO.class, Maintenance.class)
                .addMappings(mapping -> {
                    mapping.skip(Maintenance::setId);
                });

        return modelMapper;
    }
}