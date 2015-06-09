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
		return new Index();
	}
	
	@POST
	@Timed
	@Path("login-details")
	@Produces(MediaType.TEXT_HTML)
	public View loginDetails(@FormParam("username") String username,
			 			     @FormParam("password") String password){
		if(username.equalsIgnoreCase("damien") && password.equalsIgnoreCase("password")){
			return new LoginSuccessView();
		} else {
			return new LoginFailureView();
		}
	}
}
