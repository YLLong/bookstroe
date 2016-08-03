package com.itarena.category.javabean;

public class Book {
	
	private String bid;
	private String bname;
	private String author;
	private Double price;
	private String image;
	private Category category_cid;
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}	
	public Category getCategory_cid() {
		return category_cid;
	}
	public void setCategory_cid(Category category_cid) {
		this.category_cid = category_cid;
	}
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", price=" + price + ", image=" + image
				+ ", category_cid=" + category_cid + "]";
	}
	
}
