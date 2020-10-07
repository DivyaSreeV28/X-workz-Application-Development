package com.xworkz.springbootweb.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

//@Data
public class MessageDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(MessageDto.class);
	
	private int id;
	private String fromMessage;
	private String message;
	private String toMessage;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromMessage() {
		return fromMessage;
	}
	public void setFromMessage(String fromMessage) {
		this.fromMessage = fromMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToMessage() {
		return toMessage;
	}
	public void setToMessage(String toMessage) {
		this.toMessage = toMessage;
	}
	public MessageDto() {
		logger.info("Created Message entity");
	}
	public MessageDto(int id, String fromMessage, String message, String toMessage) {
		super();
		this.id = id;
		this.fromMessage = fromMessage;
		this.message = message;
		this.toMessage = toMessage;
	}
	public MessageDto(String fromMessage, String message, String toMessage) {
		super();
		this.fromMessage = fromMessage;
		this.message = message;
		this.toMessage = toMessage;
	}
	@Override
	public String toString() {
		return "MessageEntity [id=" + id + ", fromMessage=" + fromMessage + ", message=" + message + ", toMessage="
				+ toMessage + "]";
	}
	
}
