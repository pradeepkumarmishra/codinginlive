package com.pradeep.rs.Mmessanger.service;

import java.util.ArrayList;
import java.util.List;

import com.pradeep.rs.Messanger.model.Message;

public class MessageService {

	
	public static List<Message> getAllMessage(){
		List<Message> msgList=new ArrayList<Message>();
		Message msg1=new Message(1,"Message 1","comment 1 for Msg1");
		Message msg2=new Message(2,"Message 2","comment 1 for Msg2");
		Message msg3=new Message(3,"Message 3","comment 1 for Msg3");
		msgList.add(msg1);
		msgList.add(msg2);
		msgList.add(msg3);
		
			return msgList;
		
				
	}
}
