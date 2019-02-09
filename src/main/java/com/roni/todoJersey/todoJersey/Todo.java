package com.roni.todoJersey.todoJersey;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.istack.internal.NotNull;


@Path("/Todo")
@Produces(MediaType.TEXT_PLAIN)
public class Todo {
	DAO dao;
	ArrayList<Item> listOfItems;
	String id,date,note,status;
	public Todo() {
        super();
		System.out.println("constructor");
		dao = new DAO();
    }
	@GET
	@Path("/GetData")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
    public ArrayList<Item> GetData() {
        listOfItems = dao.getItems();
		return listOfItems;
    }
	@GET
	@Path("/AddItem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public Response AddItem(@Valid @NotNull @QueryParam("note") String note,@Valid @NotNull @QueryParam("date") String date) {
		System.out.println(note);
		if(dao.addItem(date,note))
			 return Response.ok().status(200).entity(Boolean.TRUE.toString()).build();
		return Response.ok().status(200).entity(Boolean.FALSE.toString()).build();
    }
	@GET
	@Path("/DeleteItem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public Response DeleteItem(@Valid @NotNull @QueryParam("id") String id) {
		if(dao.deleteItem(id))
			 return Response.ok().status(200).entity(Boolean.TRUE.toString()).build();
		return Response.ok().status(200).entity(Boolean.FALSE.toString()).build();
    }
	@GET
	@Path("/UpdateItem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public Response UpdateItem(@Valid @NotNull @QueryParam("id") String id,@Valid @NotNull @QueryParam("note") String note) {
		if(dao.updateItem(id,note)) 
			 return Response.ok().status(200).entity(Boolean.TRUE.toString()).build();
		return Response.ok().status(200).entity(Boolean.FALSE.toString()).build();
    }
	@GET
	@Path("/DoneItem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public Response DoneItem(@Valid @NotNull @QueryParam("id") String id,@Valid @NotNull @QueryParam("status") String status) {
		if(dao.doneItem(id,status))
			 return Response.ok().status(200).entity(Boolean.TRUE.toString()).build();
		return Response.ok().status(200).entity(Boolean.FALSE.toString()).build();
    }
}
