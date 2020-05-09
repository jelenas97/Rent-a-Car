package com.rentCar.repository;

import com.rentCar.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "select a from Advertisement a where a.place = ?1 and a.startDate <= ?2 and a.endDate >= ?3")
    List<Advertisement> findAdvertisements(String place, LocalDate startDate, LocalDate endDate);

    @Query(value = "select a from Advertisement a where a.id = ?1")
    Advertisement find(Long id);

    @Query(value = "select a from Advertisement a inner join a.terms t where a.place = ?1 and a.startDate <= ?2 and a.endDate >= ?3" +
            " and t.canceled = false and t.startDate <= ?2 and t.endDate >= ?2 " +
            "or  a.place = ?1 and a.startDate <= ?2 and a.endDate >= ?3 and t.canceled = false and  t.startDate <= ?3 and t.endDate >= ?3 " +
            "or  a.place = ?1 and a.startDate <= ?2 and a.endDate >= ?3 and t.canceled = false and  t.startDate >= ?2 and t.endDate <= ?3")
    List<Advertisement> findTakenAdvertisements(String place, LocalDate startDate, LocalDate endDate);

}
