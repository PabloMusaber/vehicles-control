package com.challenge.Vehicles.services.vehicle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.challenge.Vehicles.dtos.vehicle.VehicleCreateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;
import com.challenge.Vehicles.entities.Vehicle;
import com.challenge.Vehicles.exceptions.VehicleNotFoundException;
import com.challenge.Vehicles.repositories.VehicleRepository;

import jakarta.transaction.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public VehicleResponseDTO createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        Vehicle vehicle = modelMapper.map(vehicleCreateDTO, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        log.info("Vehicle created with license plate: " + savedVehicle.getLicensePlate());
        return modelMapper.map(savedVehicle, VehicleResponseDTO.class);
    }

    @Override
    @Transactional
    public VehicleResponseDTO updateVehicle(VehicleUpdateDTO vehicleUpdateDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleUpdateDTO.getId())
                .orElseThrow(() -> new VehicleNotFoundException());

        modelMapper.map(vehicleUpdateDTO, existingVehicle);

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        log.info("Vehicle with license plate " + updatedVehicle.getLicensePlate() + " updated.");
        return modelMapper.map(updatedVehicle, VehicleResponseDTO.class);
    }

    @Override
    public VehicleResponseDTO getVehicleById(Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            return optionalVehicle.map(vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class)).get();
        }
        log.error("Vehicle not found by id.");
        throw new VehicleNotFoundException();
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        log.error("Vehicle not found in deleteVehicle method.");
        throw new VehicleNotFoundException();
    }

    @Override
    public VehicleResponseDTO getVehiclesByLicensePlate(String licensePlate) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(licensePlate);

        if (vehicle != null) {
            return modelMapper.map(vehicle, VehicleResponseDTO.class);
        }
        log.error("Vehicle not found by license plate.");
        throw new VehicleNotFoundException();
    }
}