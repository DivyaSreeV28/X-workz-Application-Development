package com.xworkz.springbootweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

//@Data
//@Slf4j
@Entity
@Table(name="message_table")
public class MessageEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(MessageEntity.class);
	
	@Id
	@GenericGenerator(name="xworkz",strategy = "increment")
	@GeneratedValue(generator ="xworkz")
	@Column(name="id")
	private int id;
	@Column(name="from_message")
	private String fromMessage;
	@Column(name="message")
	private String message;
	@Column(name="to_message")
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
	public MessageEntity() {
		logger.info("Created Message entity");
	}
	public MessageEntity(int id, String fromMessage, String message, String toMessage) {
		super();
		this.id = id;
		this.fromMessage = fromMessage;
		this.message = message;
		this.toMessage = toMessage;
	}
	public MessageEntity(String fromMessage, String message, String toMessage) {
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
