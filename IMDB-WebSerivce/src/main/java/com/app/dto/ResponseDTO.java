package com.app.dto;

import java.io.Serializable;

import org.springframework.http.HttpEntity;

public class ResponseDTO<T> extends HttpEntity<T> implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant serialVersionUID. */
	private String status;
	
	/** The dto object. */
    private T dtoObject;
    
    /** The error message. */
    private MessageDTO errorMessage;

    public ResponseDTO(T dtoObject) {
        this.dtoObject = dtoObject;
    }

    public ResponseDTO(String message,T dtoObject) {
        this.dtoObject = dtoObject;
        this.status = message;
    }
    
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the dtoObject
	 */
	public T getDtoObject() {
		return dtoObject;
	}

	/**
	 * @param dtoObject the dtoObject to set
	 */
	public void setDtoObject(T dtoObject) {
		this.dtoObject = dtoObject;
	}

	/**
	 * @return the errorMessage
	 */
	public MessageDTO getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(MessageDTO errorMessage) {
		this.errorMessage = errorMessage;
	}
}
