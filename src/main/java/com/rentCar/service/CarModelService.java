package com.rentCar.service;

import com.rentCar.model.CarBrand;
import com.rentCar.model.CarClass;
import com.rentCar.model.CarModel;

import java.util.List;

public interface CarModelService {
    CarModel findOne(Long id);
    List<String> findAllStringList(Long brand);
    CarModel findOneByName(String name);
    void save(String name, CarBrand brand);
    void delete(String name);
    void setActive(String name);
}
