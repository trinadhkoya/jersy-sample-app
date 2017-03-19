
package io.trinadhkoya.github.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import io.trinadhkoya.github.database.DataBaseClass;
import io.trinadhkoya.github.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello!Welcome to JAVA", "TRINADH KOYA"));
		messages.put(2L, new Message(2, "Hello", "KOYA"));

	}

	public List<Message> getMessagesByyear(int year) {
		// create an empty list which stores filtered(year) data
		List<Message> messageListByYear = new ArrayList();
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		// iterate through all the list of messages and check in side
		for (Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			//if the passed year maps with any of those message created year 
			if (calendar.get(Calendar.YEAR) == year) {
				messageListByYear.add(message);

			}

		}

		return messageListByYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> paginatedMessageList = new ArrayList<>(messages.values());
		if (start + size > paginatedMessageList.size())
			return new ArrayList<Message>();
		return paginatedMessageList.subList(start, start + size);

	}

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);

		return message;

	}

	public Message removeMessage(long id) {
		return messages.remove(id);

	}
}
