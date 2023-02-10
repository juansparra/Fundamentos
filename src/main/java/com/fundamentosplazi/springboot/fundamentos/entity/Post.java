package com.fundamentosplazi.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_post",nullable=false,unique= true)
	private Long id;
	@Column (name="descripcion", length = 255)
	private String Descripcion;
	@ManyToOne
	@JsonBackReference
	private User user;
	public Post() {
		super();
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", Descripcion=" + Descripcion + ", user=" + user + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

