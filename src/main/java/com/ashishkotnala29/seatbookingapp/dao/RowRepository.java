package com.ashishkotnala29.seatbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashishkotnala29.seatbookingapp.model.entity.Row;

public interface RowRepository extends JpaRepository<Row, Long> {

}
