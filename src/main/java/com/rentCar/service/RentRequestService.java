package com.rentCar.service;

import com.rentCar.dto.RentRequestDTO;
import com.rentCar.model.RentRequest;

import java.util.List;

public interface RentRequestService {

    List<RentRequestDTO> getHistoryRentRequests(long id);

    List<RentRequestDTO> getCancelableRentRequests(long id);

    void save(RentRequest requestDTO);
}