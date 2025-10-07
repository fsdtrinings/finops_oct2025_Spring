package com.mkj.app.exception;

public class InvalidDocumentidException extends Exception{
	
	private int docNumber;

	public InvalidDocumentidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDocumentidException(int docNumber) {
		super();
		this.docNumber = docNumber;
	}

	@Override
	public String toString() {
		return docNumber+" is not valid , must be at least 5+ char";
	}
	

}
