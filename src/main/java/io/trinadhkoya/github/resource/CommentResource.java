package io.trinadhkoya.github.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.trinadhkoya.github.model.Comment;
import io.trinadhkoya.github.service.CommentService;

@Path("/")
public class CommentResource {

	CommentService commentService = new CommentService();

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}

	@GET
	@Path("/")
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {

		return commentService.getAllComments(messageId);
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {

		return commentService.addComment(messageId, comment);
	}

	@Path("/{commentId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	
	@DELETE
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		commentService.removeComment(messageId, commentId);
	}
	
}
