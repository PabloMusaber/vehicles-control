package com.challenge.Vehicles.services.maintenance;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.challenge.Vehicles.dtos.maintenance.MaintenanceCreateDTO;
import com.challenge.Vehicles.dtos.maintenance.MaintenanceResponseDTO;
import com.challenge.Vehicles.entities.Maintenance;
import com.challenge.Vehicles.entities.Vehicle;
import com.challenge.Vehicles.exceptions.VehicleNotFoundException;
import com.challenge.Vehicles.repositories.MaintenanceRepository;
import com.challenge.Vehicles.repositories.VehicleRepository;
import com.challenge.Vehicles.services.vehicle.VehicleServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
    private final VehicleRepository vehicleRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final ModelMapper modelMapper;

    public MaintenanceServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper,
            MaintenanceRepository maintenanceRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    @Transactional
    public MaintenanceResponseDTO addMaintenance(MaintenanceCreateDTO maintenanceCreateDto) {
        Vehicle vehicle = vehicleRepository.findById(maintenanceCreateDto.getVehicleId())
                .orElseThrow(() -> {
                    log.error("Vehicle not found by ID when creating a maintenance record.");
                    return new VehicleNotFoundException();
                });

        Maintenance maintenance = modelMapper.map(maintenanceCreateDto, Maintenance.class);
        maintenance.setVehicle(vehicle);
        maintenance = maintenanceRepository.save(maintenance);

        log.info("Maintenance for vehicle with license plate number " + vehicle.getLicensePlate()
                + " performed on " + maintenanceCreateDto.getDate());

        return modelMapper.map(maintenance, MaintenanceResponseDTO.class);
    }

    @Override
    public List<MaintenanceResponseDTO> getMaintenancesByVehicle(Long vehicleId) {
        return maintenanceRepository.findByVehicleId(vehicleId).stream()
                .map(maintenance -> modelMapper.map(maintenance, MaintenanceResponseDTO.class))
                .collect(Collectors.toList());
    }

}
