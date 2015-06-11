package com.kainos.training.dropwizard.login.frontends.resources;

import io.dropwizard.views.View;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.training.dropwizard.login.frontends.views.Index;
import com.kainos.training.dropwizard.login.frontends.views.LoginFailureView;
import com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView;
import com.kainos.training.jersey.client.BaseClient;

@Path("/test")
public class ViewsResource {
	
	private BaseClient baseClient;
	
	public ViewsResource() {
		baseClient = new BaseClient();
	}

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
		try {
			if(baseClient.getLogin(username, password)){
				return new LoginSuccessView();
			} else {
				return new LoginFailureView();
			}
		} catch(RuntimeException e){
			e.printStackTrace();
			return new LoginFailureView();
		}
	}
}
