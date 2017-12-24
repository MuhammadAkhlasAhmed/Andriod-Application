package com.example.muhammadikhlas.myapplication;

public class RowItem {

	private String member_name;

	private String status;
	private String contactType;

	public RowItem(String member_name,  String status,
			String contactType) {

		this.member_name = member_name;
		this.status = status;
		this.contactType = contactType;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

}