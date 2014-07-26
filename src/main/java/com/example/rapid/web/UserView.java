package com.example.rapid.web;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UserView extends VerticalLayout implements View {
	 	private static final long serialVersionUID = 4090943458322849134L;

		public UserView() {
			setSizeFull();
			setSpacing(true);
			
			Label label = new Label("Enter your information below to log in.");
			TextField username = new TextField("Username");
			TextField password = new TextField("Password");
			
			addComponent(label);
			addComponent(username);
			addComponent(password);
			addComponent(loginButton());
		}

		@Override
		public void enter(ViewChangeEvent event) {
			Notification.show("Welcome! Please log in.");
		}
		
		private Button loginButton() {
			Button button = new Button("Log In", new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
//					getUI().getNavigator().navigateTo(.MAINVIEW);
				}
			});
			return button;
		}
}
