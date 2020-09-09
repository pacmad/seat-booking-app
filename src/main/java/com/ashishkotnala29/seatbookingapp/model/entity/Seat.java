package com.ashishkotnala29.seatbookingapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "seat")
@Getter
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private int number;

	@Column(name = "is_reserved")
	private boolean isReserved;

	@ManyToOne
	@JoinColumn(name = "row_id")
	private Row row;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public void setIsReservedToTrue() {
		this.isReserved = true;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
