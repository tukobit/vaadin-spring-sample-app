package com.example.rapid.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.example.rapid.UserService;
import com.example.rapid.domain.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(UserFormView.NAME)
public class UserFormView extends FormLayout implements View{
	 	private static final long serialVersionUID = 4090943458322849134L;
	 
	 	public static final String NAME = "Users";
	 	 
	 	private VerticalLayout content = new VerticalLayout();
	 	
	 	@Autowired
		private UserService userService;
	 	
	 	private User user = new User();
	 	
	 	private FieldGroup fieldGroup;
	 	
	 	private TextField firstName;
		private TextField lastName;
		private TextField userName;
		private  TextField id;
		private Button formButton;
	 	
	 	@PostConstruct
	    public void PostConstruct()
	    {
	 		createUI();
	 		
			setSizeFull();
			content.setSpacing(true);
			Label label = new Label("Enter your information below to log in.");
			this.addComponent(label);
			this.addComponent(id);
			this.addComponent(firstName);
			this.addComponent(lastName);
			this.addComponent(userName);
			
			HorizontalLayout buttonLayout = new HorizontalLayout();
			formButton = createButton();
			buttonLayout.addComponent(formButton);
			buttonLayout.addComponent(cancelButton());
			buttonLayout.addComponent(showListButton());
			this.addComponent(buttonLayout);
			
			id.setNullRepresentation("");
			id.setNullSettingAllowed(true);
			id.setEnabled(false);
			
			formButton.setCaption("Create User");
			initBinder(initFormBackingObject());
		}
	 	
	 	private User initFormBackingObject() {
			User user = new User();
			user.setFirstName("");
			user.setLastName("");
			user.setUserName("");
			return user;
		}

		
	 	
		public void initBinder(User user) {
//			Binding Fields
			this.user = user;
			fieldGroup = new BeanFieldGroup<User>(User.class);
			fieldGroup.setItemDataSource(new BeanItem<User>(this.user));
			fieldGroup.bindMemberFields(this);
		}

		private void createUI() {
			id = new TextField("Id");
			firstName = new TextField("First Name");
			lastName = new TextField("Last Name");
			userName = new TextField("User Name");
		}

		private boolean hasValidNumber(String str)
		{
			String regex = "[0-9]";
			return str.matches(regex);
		}
		@Override
		public void enter(ViewChangeEvent event) {
			
			if (event.getParameters() != null) {
				String idStr = event.getParameters().split("/")[0];
				if (idStr != null && hasValidNumber(idStr))
				{
					Long id = Long.parseLong(idStr);
					initBinder(userService.getUser(id));
					formButton.setCaption("Update User");
				}
			}
			else
			{
				formButton.setCaption("Create User");
				initBinder(initFormBackingObject());
			}
		}
		
		private Button createButton() {
			
			Button button = new Button("Create User", new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					try {
						fieldGroup.commit();
						System.out.println(user.getId());
						userService.save(user);
						getUI().getNavigator().navigateTo(UserListView.NAME);
					} catch (CommitException e) {
						e.printStackTrace();
					}
				}
			});
			return button;
		}
		
		private Button showListButton()
		{
			Button button = new Button("Show Users", new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					getUI().getNavigator().navigateTo(UserListView.NAME);
				}
			});
			return button;
		}
		
		private Button cancelButton() {
			Button button = new Button("Cancel", new Button.ClickListener() {
				private static final long serialVersionUID = 1905860566650817894L;

				@Override
				public void buttonClick(ClickEvent event) {
//					getUI().getNavigator().navigateTo(.MAINVIEW);
				}
			});
			return button;
		}

}
