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
@Table(name = "floor")
@Getter
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private int number;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "building_id")
	private Building building;
	
	@OneToMany(mappedBy = "floor")
	private Set<Room> rooms;

}
