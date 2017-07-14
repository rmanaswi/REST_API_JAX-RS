package org.manswi.messanger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.manswi.messanger.model.Message;
import org.manswi.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	 
	MessageService messageService=new MessageService();
	
	@GET
	public List<Message> getMessage(@QueryParam("year") int year,
			@QueryParam("size") int size,
			@QueryParam("start") int start){
		if(year>0){
			return messageService.getAllMessagesForYear(year);
		}
		if(size>0 && start>0){
			return messageService.getAllMessagesPagination(start, size);
		}
		
		return messageService.getAllMessages();
    }
	
	
	@POST
	public Message addMessages(Message message){
		
			 return  messageService.addMessage(message);
		}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessages(@PathParam("messageId") long id, Message message){
		     message.setId(id);
			 return  messageService.updateMessage(message);
		}
	
	
	
	@DELETE
	@Path("/{messageId}")
  public void deleteMessages(@PathParam("messageId") long messageId){
		
			  messageService.removeMessage(messageId);
		}
	
	
	
	
	@GET
	@Path("/{messageId}")
 public Message getMessage(@PathParam("messageId") long messageId){
		
    	return messageService.getMessage(messageId);
    }
}
