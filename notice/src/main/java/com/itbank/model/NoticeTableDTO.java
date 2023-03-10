package com.itbank.model;

import java.sql.Date;

//	IDX      NOT NULL NUMBER        
//	CATEGORY NOT NULL VARCHAR2(100) 
//	TITLE    NOT NULL VARCHAR2(255) 
//	MEMO     NOT NULL VARCHAR2(255) 
//	PWCHECK  NOT NULL VARCHAR2(255) 
//	TODAY             DATE          

public class NoticeTableDTO {
	
	private int idx;
	private String category;
	private String title;
	private String memo;
	private String pwcheck;
	private Date today;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public String getPwcheck() {
		return pwcheck;
	}
	public void setPwcheck(String pwcheck) {
		this.pwcheck = pwcheck;
	}

	
}
