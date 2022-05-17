package com.example.GradingService.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Asignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String type;
	@Column
	private String title;
	@Column
	@Lob
	@JsonIgnore
	private byte[] data;
	@Column
	private String submitDate;
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;
}
