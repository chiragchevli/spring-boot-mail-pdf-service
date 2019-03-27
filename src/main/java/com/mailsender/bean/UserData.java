package com.mailsender.bean;

import java.io.Serializable;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

@JsonSerializableSchema
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String emailTitle;
	private String pdfName;
	private String pdfData;

	public UserData() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailTitle() {
		return emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public String getPdfData() {
		return pdfData;
	}

	public void setPdfData(String pdfData) {
		this.pdfData = pdfData;
	}

	@Override
	public String toString() {
		return "UserData [email=" + email + ", emailTitle=" + emailTitle + ", pdfName=" + pdfName + ", pdfData="
				+ pdfData + "]";
	}

}
