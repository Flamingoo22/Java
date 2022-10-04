package com.fan.mvcdemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity  //declares that it is going to be part of mysql
@Table(name="donation") //gives the table name of the model
public class Donation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=3, max=255)
    @NotNull(message="donationName is required!")
    private String donationName;
    
    @Size(min=1, max=50)
    @NotEmpty(message = "Description is required!")
    private String donor;
    
    @Min(0)
    @Max(1000)
    @NotNull
    private Integer quantity;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	public Donation() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Donation(
			@Size(min = 3, max = 255) @NotNull String donationName,
			@Size(min = 1, max = 50) @NotEmpty String donor,
			@Min(0) @Max(1000) @NotNull Integer quantity) {
		this.donationName = donationName;
		this.donor = donor;
		this.quantity = quantity;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDonationName() {
		return donationName;
	}



	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}



	public String getDonor() {
		return donor;
	}



	public void setDonor(String donor) {
		this.donor = donor;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
