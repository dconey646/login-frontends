package com.kainos.training.login.frontends.login_frontends_2.resources;

import javax.ws.rs.*;
import com.codahale.metrics.annotation.*;
import javax.ws.rs.core.MediaType;
import io.dropwizard.views.*;
import com.kainos.training.login.frontends.login_frontends_2.views.*;

@Path("/test")
public class ViewsResource {
	
	public ViewsResource() { }

	@GET
	@Timed
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)	
	public View login() {
		System.out.println("Entered resource method...");
		return new Index();
	}
	
	@GET
	@Timed
	@Path("/login2")
	@Produces(MediaType.TEXT_HTML)	
	public String login2() {
		System.out.println("Entered resource method...");
		return "Sucess!";
		// return new Index();
	}

}
