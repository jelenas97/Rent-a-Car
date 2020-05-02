package com.rentCar.controller;

import com.rentCar.model.CarBrand;
import com.rentCar.service.impl.CarBrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "brand")
@CrossOrigin("http://localhost:4200")
public class CarBrandController {
    @Autowired
    private CarBrandServiceImpl carBrandService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasRole('")
    public ResponseEntity newBrand(@RequestBody String name) {

        try {
            CarBrand brand = this.carBrandService.findOneByName(name);
            if (brand != null) {
                this.carBrandService.setActive(name);
            } else {
                this.carBrandService.addBrand(name);
            }
            return new ResponseEntity(HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity deleteBrand(@PathVariable String name) {

        try {
            CarBrand brand = this.carBrandService.findOneByName(name);
            if (brand != null) {
                this.carBrandService.deleteBrand(name);
            }
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}