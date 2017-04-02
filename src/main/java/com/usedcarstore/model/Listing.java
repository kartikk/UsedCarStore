package com.usedcarstore.model;

public class Listing {

	private String title;
	private Double price;
	private String dateCreated;
	private String registrationNo;
	private String dateSold;
	private String status;
	private String email;

	public Listing() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void listings(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Listing [title=" + title + ", price=" + price + ", dateCreated=" + dateCreated + ", registrationNo="
				+ registrationNo + ", dateSold=" + dateSold + ", status=" + status + ", email=" + email + "]";
	}

	

}
