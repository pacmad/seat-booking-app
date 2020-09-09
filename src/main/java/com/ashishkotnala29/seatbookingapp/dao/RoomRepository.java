package com.ashishkotnala29.seatbookingapp.dao;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashishkotnala29.seatbookingapp.model.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	Page<Room> findByProjectDateTimeBetween(
			@RequestParam("startDateTime") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime startDateTime,
			@RequestParam("endDateTime") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime endDateTime,
			Pageable pageable);

}
