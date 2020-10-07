package com.xworkz.springbootweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springbootweb.dto.MessageDto;
import com.xworkz.springbootweb.entity.MessageEntity;
import com.xworkz.springbootweb.exceptions.MessageNotFoundException;
import com.xworkz.springbootweb.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);

	@Override
	public MessageEntity saveMessage(MessageDto messageDto) {
		MessageEntity messageEntity= null;
		try {
			logger.info("Started: saveMessage from MessageServiceImpl ");
			if (Objects.nonNull(messageDto)) {
				
				logger.info("-------------------Saving entity into message_table "+messageDto);
				messageEntity=modelMapper.map(messageDto, MessageEntity.class);
				messageRepository.save(messageEntity);

			}else {
				throw new MessageNotFoundException("Message entered is empty");
			}
			return messageEntity;
		} catch (Exception e) {
			logger.error("Exception in saveMessage ", e);
			System.out.println(e);
		}
		logger.info("Ended: saveMessage from MessageServiceImpl");
		return messageEntity;
	}

	@Override
	public List<MessageEntity> getAllMessages() {
		List<MessageEntity> messageList =null;
		try {
			logger.info("Started: getAllMessages from MessageServiceImpl");
			 messageRepository.findAll();
			if (Objects.nonNull(messageList)) {
				return messageList;
			} else {
				return new ArrayList<MessageEntity>();
			}
		} catch (Exception e) {
			logger.error("Exception in getAllMessages ", e);
		}
		logger.info("Ended: getAllMessages from MessageServiceImpl");
		return messageList;

	}

	@Override
	public MessageEntity getMessagesById(int id) {
		Optional<MessageEntity> messageList =null;
		try {
			logger.info("Started: getMessagesById from MessageServiceImpl");
			messageRepository.findById((long) id);

			if (Objects.nonNull(messageList)) {
				return messageList.get();
			}else {
				throw new MessageNotFoundException("Message for given id: "+id+" not found");
			}
		} catch (Exception e) {
			logger.error("Exception in getMessagesById ", e);
		} 
		logger.info("Ended: getMessagesById from MessageServiceImpl");
		return messageList.get();
	}

	@Override
	public MessageEntity createOrUpdateMessage(MessageDto messageDto) {
		MessageEntity messageEntity=null;
		try {
			logger.info("Started: createOrUpdateMessage from MessageServiceImpl");
			if (Objects.nonNull(messageDto)) {
				messageEntity=modelMapper.map(messageDto, MessageEntity.class);
				
				Optional<MessageEntity> message = messageRepository.findById((long) messageDto.getId());

				if (message.isPresent()) {
					MessageEntity fetchedMsgEntity = message.get();
					fetchedMsgEntity.setFromMessage(messageDto.getFromMessage());
					fetchedMsgEntity.setMessage(messageDto.getMessage());
					fetchedMsgEntity.setToMessage(messageDto.getToMessage());

					fetchedMsgEntity = messageRepository.save(fetchedMsgEntity);

					return fetchedMsgEntity;
				} else {
					messageEntity = messageRepository.save(messageEntity);

					return messageEntity;
				}
			} else {
				messageEntity = messageRepository.save(messageEntity);
				return messageEntity;
			}
		} catch (Exception e) {
			logger.error("Exception in createOrUpdateMessage ", e);
		}
		logger.info("Ended: createOrUpdateMessage from MessageServiceImpl");
		return messageEntity;
	}

	@Override
	public void deleteMessageById(int id) {
		try {
			logger.info("Started: deleteMessageById from MessageServiceImpl");
			Optional<MessageEntity> messageEntity = messageRepository.findById((long) id);

			if (messageEntity.isPresent()) {
				messageRepository.deleteById((long) id);
				logger.info("Deleted "+id);
			}else {
				throw new MessageNotFoundException("Message for given id: "+id+" not found");
			}
			
		} catch (Exception e) {
			logger.error("Exception in deleteMessageById ", e);
		}
		logger.info("Ended: deleteMessageById from MessageServiceImpl");
	}

}
