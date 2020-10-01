package com.xworkz.springbootweb.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.springbootweb.dto.MessageDto;
import com.xworkz.springbootweb.entity.MessageEntity;
import com.xworkz.springbootweb.service.MessageService;

@Controller
public class WelcomeController {
	
	private static final Logger logger = Logger.getLogger(WelcomeController.class);
	
	@Autowired
	MessageService messageService;

	public WelcomeController() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("onclick")
	public String onClick() {
		logger.info("Invoked onClick");
		return "Welcome";
	}

	@RequestMapping("welcome")
	public String saveMessage(MessageDto messageDto, Model model) {
		try {
			logger.info("Started: saveMessage "+messageDto);
			logger.info("Invoked welcome page ");

			if (Objects.nonNull(messageDto)) {
				
				MessageEntity fetechedMessage= messageService.saveMessage(messageDto);
				logger.info(fetechedMessage);
				
				model.addAttribute("fromMessage", messageDto.getFromMessage());
				model.addAttribute("message", messageDto.getMessage());
				model.addAttribute("toMessage", messageDto.getToMessage());
				
				logger.info("Directing to DisplayMessage.jsp");
				return "DisplayMessage";
				
			} else {
				logger.info("Message not valid");
				model.addAttribute("Error", "Please check which field and enter valid data");
				return "Welcome";
			}
		} catch (Exception e) {
			logger.error("Exception in saveMessage controller " + e);
		}
		logger.info("Ended: saveMessage "+messageDto);
		return "DisplayMessage";
	}
	
}