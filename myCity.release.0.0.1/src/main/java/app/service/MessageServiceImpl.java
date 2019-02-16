package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Message;
import app.model.Person;
import app.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public Message getMessageNoOpt(Long id) {
		return messageRepository.getMessageNoOpt(id);
	}

	@Override
	public Message editMessage(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public void deleteMessage(Message message) {
		messageRepository.delete(message);
	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
		
	}

	@Override
	public List<Message> getMessageByPerson(Person person) {
		return messageRepository.getMessageByPerson(person);
	}


}
