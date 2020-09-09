package com.ashishkotnala29.seatbookingapp.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "row")
@Getter
public class Row {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "row_index")
	private int rowIndex;

	@Column(name = "number_of_seats")
	private int numberOfSeats;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@OneToMany(mappedBy = "row")
	private Set<Seat> seats;

}
