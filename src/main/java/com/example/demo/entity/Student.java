package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
public class Student {
	@NotFound(action = NotFoundAction.IGNORE)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String studentId;
	private double chuyenCan;
	private double baiTap;
	private double thucHanh;
	private double cuoiKy=0.0;
}
