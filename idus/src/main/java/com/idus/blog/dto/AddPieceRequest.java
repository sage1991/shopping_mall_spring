package com.idus.blog.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.idus.auth.dto.Authorization;

public class AddPieceRequest {
	
	private String title;
	private String pieceName;
	private long price;
	private List<String> options;
	private long deliveryCharge;
	private int discount;
	private MultipartFile thumbnail;
	private List<MultipartFile> images;
	private String description;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPieceName() {
		return pieceName;
	}
	
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public long getDeliveryCharge() {
		return deliveryCharge;
	}
	
	public void setDeliveryCharge(long deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public MultipartFile getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public List<MultipartFile> getImages() {
		return images;
	}
	
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void transferTo(Piece piece, HttpSession session) {
		piece.setArtistNo(((Authorization) session.getAttribute("auth")).getMemberNo());
		piece.setTitle(this.getTitle());
		piece.setPieceName(this.getPieceName());
		piece.setPrice(this.getPrice());
		piece.setDeliveryCharge(this.getDeliveryCharge());
		piece.setDiscount(this.getDiscount());
		piece.setDescription(this.getDescription());
		piece.setCreatedDate(LocalDateTime.now());
	}

}