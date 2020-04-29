package com.rentCar.repository;

import com.rentCar.model.CarBrand;
import com.rentCar.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    FuelType findByName(String name);
    @Query(value = "select c from FuelType c where c.active=true")
    List<FuelType> getActiveFuelTypes();
}
