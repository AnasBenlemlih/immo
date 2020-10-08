package com.example.demo.responses;

public enum ErreurMessages {
	
	MISSING_REQUIRED_FIELD("Missing required field."),
	RECORD_ALREADY_EXISTS("Record already exists."),
	INTERNAL_SERVER_ERROR("Internal Immo Server error."),
	NO_RECORD_FOUND("Record with provided ID is not found.");
	
	private String errorMessage;

	private ErreurMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
