package com.xworkz.springbootweb.service;

import java.util.List;

import com.xworkz.springbootweb.dto.MessageDto;
import com.xworkz.springbootweb.entity.MessageEntity;

public interface MessageService {
	
	public MessageEntity saveMessage(MessageDto messageDto);
	
	public List<MessageEntity> getAllMessages();

	public MessageEntity getMessagesById(int id);

	public MessageEntity createOrUpdateMessage(MessageDto messageDto);

	public void deleteMessageById(int id);

}
