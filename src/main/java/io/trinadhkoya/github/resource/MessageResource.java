package io.trinadhkoya.github.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.trinadhkoya.github.model.Message;
import io.trinadhkoya.github.param.MessageParam;
import io.trinadhkoya.github.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	// @GET
	// @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// public List<Message> getMessages(@QueryParam("year") int year,
	// @QueryParam("start") int start,
	// @QueryParam("size") int size) {
	// /**
	// * if you feel bad about using these @QueryParam like this way. just go
	// * for bean parameters.you can see the below commented method
	// **/
	//
	// if (year > 0) {
	// return messageService.getMessagesByyear(year);
	// }
	//
	// if (start >= 0 && size > 0) {
	// return messageService.getAllMessagesPaginated(start, size);
	// }
	//
	// return messageService.getAllMessages();
	//
	// }

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Message> getMessages(@BeanParam MessageParam messageFilterParm) {
		/**
		 * if you feel bad about using these @QueryParam like this way. just go
		 * for bean parameters.you can see the below commented method
		 **/

		if (messageFilterParm.getYear() > 0) {
			return messageService.getMessagesByyear(messageFilterParm.getYear());
		}

		if (messageFilterParm.getStart() >= 0 && messageFilterParm.getSize() > 0) {
			return messageService.getAllMessagesPaginated(messageFilterParm.getStart(), messageFilterParm.getSize());
		}

		return messageService.getAllMessages();

	}

	@GET
	@Path("/{messageId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	public Message getMessage(@PathParam("messageId") Long messageId) {
		return messageService.getMessage(messageId);
	}

	// /**
	// * adds a new message to the list/Database
	// */
	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public Message addMessage(Message message) {
	// messageService.addMessage(message);
	// return message;
	// }

	/** the same addMessage which returns response **/
	/**
	 * apart from creating a message,which also includes response with various
	 * header data and so on Using Response and Context param 
	 * 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message,@Context UriInfo info) {
		Message newMessage = messageService.addMessage(message);
		String newMessageId=String.valueOf(newMessage.getId());
		URI uri=info.getAbsolutePathBuilder().path(newMessageId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(Message message, @PathParam("messageId") long id) {
		message.setId(id);
		messageService.updateMessage(message);
		return message;
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

	/**
	 * what if we get request something like this "/{messageId}/comments .we
	 * have to pass them corresponding API ,in this i have created
	 * CommentResource as API,like wise you can create ShareResource,..etc.It
	 * will be easy if you navigate and handle the stuff in those
	 */

	/** METHODS not required **/
	/**
	 * this is the method level path for the Sub Resource i.e CommentResource
	 **/
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		// it looks for the CommentResource i.e SubResource for this
		// MessageResource
		return new CommentResource();
	}

}
