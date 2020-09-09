package com.ashishkotnala29.seatbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashishkotnala29.seatbookingapp.model.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}
