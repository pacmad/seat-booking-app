package com.ashishkotnala29.seatbookingapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResultDTO {

	private BigDecimal totalCost;

	private LocalDateTime reservationExpirationTime;

	public BookingResultDTO(LocalDateTime reservationExpirationTime) {
		this.reservationExpirationTime = reservationExpirationTime;
	}

}
