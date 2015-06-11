package com.kainos.training.dropwizard.login.frontends.resources;

import io.dropwizard.views.View;

import org.junit.Before;
import org.junit.Test;

import com.kainos.training.dropwizard.login.frontends.views.Index;
import com.kainos.training.dropwizard.login.frontends.views.LoginFailureView;
import com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView;
import com.kainos.training.jersey.client.BaseClient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class ViewsResourceTest {
	
	private ViewsResource viewsResource;
	private BaseClient baseClient;
	
	@Before
	public void setup(){
		baseClient = mock(BaseClient.class);
		viewsResource = new ViewsResource(baseClient);
	}
	
	@Test
	public void shouldReturnIndexViewWhenHit(){
		View actualView = viewsResource.login();
		
		assertThat(actualView, is(instanceOf(Index.class)));
	}
	
	@Test
	public void shouldReturnLoginSuccessWhenLoginIsSuccessful(){
		when(baseClient.getLogin(anyString(), anyString())).thenReturn(true);
		
		View actualView = viewsResource.loginDetails("username", "password");
		
		assertThat(actualView, is(instanceOf(LoginSuccessView.class)));
	}
	
	@Test
	public void shouldReturnLoginFailureWhenLoginIsIncorrect(){
		when(baseClient.getLogin(anyString(), anyString())).thenReturn(false);
		
		View actualView = viewsResource.loginDetails("test","test password");
		
		assertThat(actualView, is(instanceOf(LoginFailureView.class)));
	}
}
