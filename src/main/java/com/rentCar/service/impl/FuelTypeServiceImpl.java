package com.rentCar.service.impl;

import com.rentCar.model.FuelType;
import com.rentCar.repository.FuelTypeRepository;
import com.rentCar.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Override
    public FuelType findOne(Long id) {
        return fuelTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<FuelType> findAll() {
        return fuelTypeRepository.findAll();
    }

    @Override
    public FuelType findOneByName(String name) {
        return this.fuelTypeRepository.findByName(name);
    }

    @Override
    public void save(String name) {
        this.fuelTypeRepository.save(new FuelType(name));
    }

    @Override
    public void delete(FuelType fuelType) {
        fuelType.setActive(false);
        this.fuelTypeRepository.save(fuelType);

    }

    @Override
    public void setActive(String name) {
        FuelType fuelType = this.fuelTypeRepository.findByName(name);
        fuelType.setActive(true);
        this.fuelTypeRepository.save(fuelType);
    }

    @Override
    public List<FuelType> findAllActive() {
        return fuelTypeRepository.getActiveFuelTypes();
    }
}
