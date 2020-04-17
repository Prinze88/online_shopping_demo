package com.j2ee.onlineShoppingBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "is_active")
	private Boolean active= true;
	
	
	public Category(int id, String name, String description, String imageUrl, Boolean active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.active = active;
	}
	
	
	public Category() {
	}


	public Category(String name, String description, String imageUrl, Boolean active) {
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.active = active;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", active=" + active + "]";
	}
	
	

	
	
	
}
