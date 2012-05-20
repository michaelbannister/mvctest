package uk.co.michaelbannister.mvctest.app;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

class ContextWrapper implements ApplicationContextAware {

	public void setApplicationContext(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	@Delegate
	private WebApplicationContext ctx;
	
	
}