package app.service;

import java.util.List;

import app.model.Message;
import app.model.Person;

public interface MessageService {
	Message createMessage(Message message);

	Message getMessageNoOpt(Long id);
	
	Message editMessage(Message message);

	void deleteMessage(Message message);

	void deleteMessage(Long id);
	
	List<Message> getMessageByPerson(Person person);
	
}
