package com.idus.myPage.dto;

import com.idus.blog.dto.Options;

public class ShoppingBag {
	private int spbNo;			// 쇼핑백 번호
	private int customerNo;		// 고객번호
	private int artistNo;		// 판매자번호
	private String artistNick;	// 판매자닉네임
	private int pieceNo;		// 작품번호
	private String pieceName;	// 작품이름
	private int optionNo;		// 옵션번호
	private String options;		// 옵션내용
	private int amount;			// 수량
	private int price;			// 가격
	private int totalPrice;		// 상품총액
	private int url;			// 상품썸내일

	public int getSpbNo() {
		return spbNo;
	}

	public void setSpbNo(int spbNo) {
		this.spbNo = spbNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}
	
	public String getArtistNick() {
		return artistNick;
	}

	public void setArtistNick(String artistNick) {
		this.artistNick = artistNick;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPieceNo() {
		return pieceNo;
	}

	public void setPieceNo(int pieceNo) {
		this.pieceNo = pieceNo;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options.getOptions();
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int price, int amount) {
		this.totalPrice = price * amount;
	}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}

}
