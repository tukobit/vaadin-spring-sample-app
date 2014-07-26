package com.example.rapid.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.PageState;
import com.vaadin.ui.UI;

@Component
@Scope("prototype")
public class RapidWorkHoursUI extends UI {

	public Page createNewWindow() {
		final Page page = Page.getCurrent();
//		page.get
	  
		// remove window on close to avoid memory leaks
//		TODO: Closing the page need to be handled
//		page.addListener(new CloseListener() {
//			public void windowClose(CloseEvent e) {
//				if (getMainWindow() != window) {
//					RapidWorkHoursUI.this.removeWindow(window);
//				}
//			}
//		});

		return page;
	}

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
//		createNewWindow();
	}

	@Override
	public Page getPage() {
		// See if the window already exists in the application
		PageState state = new PageState();
		Page window = new RapidWorkHoursWindow(this, state);
		return window;
	}
}
