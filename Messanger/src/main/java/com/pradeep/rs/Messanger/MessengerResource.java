package com.pradeep.rs.Messanger;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pradeep.rs.Messanger.model.Message;
import com.pradeep.rs.Mmessanger.service.MessageService;

@Path("/messages")
public class MessengerResource {

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public List<Message> getMessage(){
	
		return MessageService.getAllMessage();
	}
}
