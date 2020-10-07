package com.xworkz.springbootweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.xworkz.springbootweb.controller.WelcomeController;
import com.xworkz.springbootweb.dto.MessageDto;
import com.xworkz.springbootweb.service.MessageService;

//@WebMvcTest(value=WelcomeController.class)
class WelcomeControllerTest {

//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private MessageService messageService;
	
	@Test
	public void testRegistration() {
//		MessageDto mockMsgDto = new MessageDto("divya","hello good morning..","everyone");
		
//		assertTrue(messageService.saveMessage(mockMsgDto));

	}

}
