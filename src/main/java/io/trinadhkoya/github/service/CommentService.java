package io.trinadhkoya.github.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.trinadhkoya.github.database.DataBaseClass;
import io.trinadhkoya.github.model.Comment;
import io.trinadhkoya.github.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DataBaseClass.getMessages();

	private Map<Long, Comment> comments =new HashMap<>();

//	public CommentService() {
//		// TODO Auto-generated constructor stub
//		comments.put(1L, new Comment(1,"Hello comment","trinadh"));
//		comments.put(2L, new Comment(2,"Hello comment","trinadh"));
//		comments.put(3L, new Comment(3,"Hello comment","trinadh"));
//		comments.put(2L, new Comment(1,"Hello comment","trinadh"));
//
//	}

	/**
	 * get all comments for the message.so we need a message id at any thing
	 */
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());

	}

	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);

	}

	public Comment addComment(long messageId, Comment comment) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(messages.size() + 1);
		comments.put(comment.getId(), comment);

		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);

	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comments.size() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;

	}
	
	
	

}
